package com.nexos.admision.services;

import java.util.List;

import com.nexos.admision.models.Articulo;
import com.nexos.admision.models.Usuario;

public interface IArticuloService {

	public List<Articulo> findAll();
	
	public Articulo findById(Long id);
	
	public Articulo findByNombre(String nombre);
	
	public Articulo save(Articulo articulo);
	
	public void deleteById(Long id);
	
	public void delete(Articulo articulo);
	
	public List<Articulo> findArticuloByNombreAndUsername(String nombre, String username);
	
	public List<Usuario> findUsuariosOfArticulos();
	
}
