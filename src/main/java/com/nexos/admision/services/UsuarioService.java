package com.nexos.admision.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nexos.admision.models.Usuario;
import com.nexos.admision.repositories.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{
	
	@Autowired
	private UsuarioRepository usuariosRepository;
	
	@Override
	@Transactional(readOnly=true)
	public Usuario findUsuarioByUsername(String username) {
		return usuariosRepository.findUsuarioByUsername(username);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Usuario findUsuarioById(Long id) {
		return usuariosRepository.findById(id).orElse(null);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuariosRepository.save(usuario);
	}

	@Override
	public void deleteById(Long id) {
		usuariosRepository.deleteById(id);
	}

	@Override
	public void delete(Usuario usuario) {
		usuariosRepository.delete(usuario);
	}

	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) usuariosRepository.findAll();
	}



}
