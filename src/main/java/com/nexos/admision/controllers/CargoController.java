package com.nexos.admision.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.admision.models.Cargo;
import com.nexos.admision.services.CargoService;

@CrossOrigin(origins = {"*"})
@RequestMapping("/Api")
@RestController
public class CargoController {
	
	@Autowired
	private CargoService cargoService;
	
	@GetMapping("/cargos")
	public ResponseEntity<?> listCargo(){
		Map<String, Object> response = new HashMap<>();
		List<Cargo> cargos = cargoService.findAll();
		if(cargos.size() == 0) {
			response.put("mensaje", "No existen cargos");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Cargo>>(cargos,HttpStatus.OK);
	}
	
	@GetMapping("/cargosById")
	public ResponseEntity<?> cargo(@RequestParam Long id){
		Cargo cargo = cargoService.findById(id);
		return new ResponseEntity<Cargo>(cargo,HttpStatus.OK);
	}
	
	@PostMapping("/cargos")
	public ResponseEntity<?> created(@RequestBody Cargo cargo) {
		Cargo cargoNew = cargoService.save(cargo);
		return new ResponseEntity<Cargo>(cargoNew,HttpStatus.OK);
	}

}
