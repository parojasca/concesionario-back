package com.automotor.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.automotor.demo.model.Cargo;
import com.automotor.demo.repository.CargoRepository;

@RestController
@RequestMapping("/api/v1/")
public class CargoController {

	@Autowired
	CargoRepository cargoRepository;

	@GetMapping("/cargos")
	public List<Cargo> getAllCargo() {
		return cargoRepository.findAll();
	}

	@PostMapping("/crearCargo")
	public Cargo crearCargo(@RequestBody Cargo cargo) {
		return cargoRepository.save(cargo);
	}

}
