package com.nexos.admision.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.admision.models.Cargo;
import com.nexos.admision.repositories.CargoRepository;

@Service
public class CargoService implements ICargoService{
	
	@Autowired
	private CargoRepository cargoRepository;

	@Override
	public List<Cargo> findAll() {
		return (List<Cargo>) cargoRepository.findAll();
	}
	
	@Override
	public Cargo findById(Long id) {
		return cargoRepository.findById(id).orElse(null);
	}

	@Override
	public Cargo save(Cargo cargo) {
		return cargoRepository.save(cargo);
	}

	@Override
	public void deleteById(Long id) {
		cargoRepository.deleteById(id);
	}

	@Override
	public void delete(Cargo cargo) {
		cargoRepository.delete(cargo);
	}



}
