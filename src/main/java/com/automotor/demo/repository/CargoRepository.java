package com.automotor.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.automotor.demo.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
