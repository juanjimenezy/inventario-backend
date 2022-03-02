package com.nexos.admision.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nexos.admision.models.Articulo;
import com.nexos.admision.models.Usuario;
import com.nexos.admision.repositories.ArticuloRepository;

@Service
public class ArticuloService implements IArticuloService{
	
	@Autowired
	private ArticuloRepository articuloRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Articulo> findAll() {
		return (List<Articulo>) articuloRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Articulo findById(Long id) {
		return articuloRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional()
	public Articulo save(Articulo articulo) {
		Date currentDate = new Date();
		boolean bFechaing = articulo.getFechaIng().getTime() <= currentDate.getTime();
		
		boolean bExistNombre = true;
		List<Articulo> listArticulo = articuloRepository.findArticulosByNombre(articulo.getNombre());
		if (listArticulo.size() > 0) {
			bExistNombre = false;
		}
		
		if (bFechaing && bExistNombre) {
			return articuloRepository.save(articulo);
		}else {
			return null;
		}
	}

	@Override
	public void deleteById(Long id) {
		articuloRepository.deleteById(id);
		
	}

	@Override
	public void delete(Articulo articulo) {
		articuloRepository.delete(articulo);
	}

	@Override
	public List<Articulo> findArticuloByNombreAndUsername(String nombre, String username) {
		return articuloRepository.findArticuloByNombreAndUsername(nombre,username);
	}

	@Override
	public Articulo findByNombre(String nombre) {
		return (Articulo) articuloRepository.findArticuloByNombre(nombre);
	}

	@Override
	public List<Usuario> findUsuariosOfArticulos() {
		return articuloRepository.findUsuarios();
	}
	
	

}
