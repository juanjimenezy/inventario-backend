package com.nexos.admision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = {"http://127.0.0.1:4200","http://127.0.0.1:8070","http://localhost:4200","http://localhost:8070","http://191.88.101.56:8070"})
@SpringBootApplication
public class InventarioBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioBackendApplication.class, args);
	}

}
