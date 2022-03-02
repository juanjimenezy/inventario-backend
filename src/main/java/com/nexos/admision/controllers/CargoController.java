package com.nexos.admision.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.admision.models.Cargo;
import com.nexos.admision.services.CargoService;

@RequestMapping("/Api")
@RestController
public class CargoController {
	
	@Autowired
	private CargoService cargoService;
	
	@GetMapping("/cargos")
	public List<Cargo> listCargo(){
		return cargoService.findAll();
	}
	
	@GetMapping("/cargosById")
	public Cargo cargo(@RequestParam Long id){
		return cargoService.findById(id);
	}
	
	@PostMapping("/cargos")
	public Cargo created(@RequestBody Cargo cargo) {
		return cargoService.save(cargo);
	}

}
