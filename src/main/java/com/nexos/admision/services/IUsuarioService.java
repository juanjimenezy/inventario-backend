package com.nexos.admision.services;

import java.util.List;

import com.nexos.admision.models.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public Usuario findUsuarioById(Long id);
	
	public Usuario findUsuarioByUsername(String username);
	
	public Usuario save(Usuario usuario);
	
	public void deleteById(Long id);
	
	public void delete(Usuario usuario);

}
