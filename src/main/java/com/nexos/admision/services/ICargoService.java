package com.nexos.admision.services;

import java.util.List;

import com.nexos.admision.models.Cargo;

public interface ICargoService {
	
	public List<Cargo> findAll();
	
	public Cargo findById(Long id);
	
	public Cargo save(Cargo cargo);
	
	public void deleteById(Long id);
	
	public void delete(Cargo cargo);
	
}
