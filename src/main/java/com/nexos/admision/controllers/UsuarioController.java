package com.nexos.admision.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.admision.models.Usuario;
import com.nexos.admision.services.UsuarioService;

@CrossOrigin(origins = {"*"})
@RequestMapping("/Api")
@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public ResponseEntity<?> listUsuarios() {
		Map<String, Object> response = new HashMap<>();
		List<Usuario> usuarios = null;
		try {
			usuarios = usuarioService.findAll();
			if(usuarios.size() == 0) {
				response.put("mensaje", "No existen cargos");
				return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response.put("mensaje", "Error al obtener usuarios.");
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Usuario>>(usuarios,HttpStatus.OK);
	}
	
	@GetMapping("/usuarios/{id}")
	public Usuario getUsuario(@PathVariable Long id) {
		return usuarioService.findUsuarioById(id);
	}
	
	@DeleteMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		usuarioService.deleteById(id);
	}
	
	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario created(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}
	
	
	
}
