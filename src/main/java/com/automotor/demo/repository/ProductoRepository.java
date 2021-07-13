package com.automotor.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automotor.demo.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
