package com.nexos.admision.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.admision.models.Articulo;
import com.nexos.admision.models.Usuario;
import com.nexos.admision.services.ArticuloService;
import com.nexos.admision.services.UsuarioService;

@CrossOrigin(origins = {"*"})
@RequestMapping("/Api")
@RestController
public class ArticuloController {
	
	@Autowired
	private ArticuloService articuloService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@GetMapping("/articulos")
	public ResponseEntity<?>  listArticulos(){
		Map<String, Object> response = new HashMap<>();
		List<Articulo> articulos = articuloService.findAll();
		if (articulos.size() == 0) {
			response.put("mensaje", "No existen clientes");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Articulo>>(articulos,HttpStatus.OK);
	}
	
	@GetMapping("/articulos/{id}")
	public ResponseEntity<?> articuloById(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		Articulo articulo = articuloService.findById(id);
		if (articulo == null) {
			response.put("mensaje", "El cliente no existe");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Articulo>(articulo,HttpStatus.OK);
	}
	
	@PostMapping("/articulos")
	public ResponseEntity<?> created(@RequestParam Long id, @RequestBody Articulo articulo) {
		Map<String, Object> response = new HashMap<>();
		Articulo articulor = new Articulo();
		
		Date currentDate = new Date();
		Usuario usuario = usuarioService.findUsuarioById(id);
		articulo.setUsernameIng(usuario);
		articulo.setUsernameAct(usuario);
		articulo.setFechaIng(currentDate);
		
		try {
			articulor = articuloService.save(articulo);
			
			if(articulor == null) {
				response.put("mensaje", "El articulo posiblemente ya existe.");
				return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al grabar.");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Articulo>(articulor,HttpStatus.CREATED);
	}
	
	@PutMapping("/articulos")
	public Articulo update(@RequestParam Long id,@RequestParam Long user, @RequestBody Articulo articulo) {
		Articulo articuloAct = articuloService.findById(id);
		Usuario usuario = usuarioService.findUsuarioById(user);
		
		articuloAct.setNombre(articulo.getNombre());
		articuloAct.setProducto(articulo.getProducto());
		articuloAct.setCantidad(articulo.getCantidad());
		articuloAct.setFechaIng(articulo.getFechaIng());
		articuloAct.setUsernameAct(usuario);
		return articuloService.save(articuloAct);
	}
	
	
	@DeleteMapping("/articulos")
	public ResponseEntity<?> deleteById(@RequestParam Long id, @RequestParam Long idUSer) {
		Map<String, Object> response = new HashMap<>();
		try {
			Usuario usuario = usuarioService.findUsuarioById(idUSer);
			Articulo articulo = articuloService.findById(id);
			if (articulo.getUsernameIng().getId() == usuario.getId()) {
				articuloService.delete(articulo);
			}else {
				response.put("mensaje", "Este registro solo el usuario de ingreso puede eliminarlo.");
				return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CONFLICT);
			}
			
		} catch (Exception e) {
			response.put("mensaje", "Error al eliminar.");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	} 
	 
	@DeleteMapping("/allArticulos")
	public ResponseEntity<?> delete(@RequestBody Articulo articulo) {
		Map<String, Object> response = new HashMap<>();
		try {
			articuloService.delete(articulo);
		} catch (Exception e) {
			response.put("mensaje", "Error al eliminar.");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/articulosFiltro")
	public ResponseEntity<?> filtro(@RequestParam(required=false, defaultValue = "%") String nombre, @RequestParam(required=false, defaultValue = "%") String usuario){
		Map<String, Object> response = new HashMap<>();
		List<Articulo> articulos = articuloService.findArticuloByNombreAndUsername(nombre,usuario);
		if (articulos.size() == 0) {
			response.put("mensaje", "No existen registros para tu buesqueda");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Articulo>>(articulos,HttpStatus.OK);
	}
	
	@GetMapping("/articulosUsers")
	public ResponseEntity<?> findUsuariosOfArticulos(){
		Map<String, Object> response = new HashMap<>();
		List<Usuario> usuarios = articuloService.findUsuariosOfArticulos();
		if (usuarios.size() == 0) {
			response.put("mensaje", "No hay usuarios registrados");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Usuario>>(usuarios,HttpStatus.OK);
	}
	
	@GetMapping("/articulosByNom")
	public ResponseEntity<?> findArticuloByNombre(@RequestParam String nombre) {
		Map<String, Object> response = new HashMap<>();
		Articulo articulo = null;
		try {
			articulo = articuloService.findByNombre(nombre);
		} catch (Exception e) {
			response.put("mensaje", "Error interno.");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Articulo>(articulo,HttpStatus.OK);
	}

}
