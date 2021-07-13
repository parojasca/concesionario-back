package com.automotor.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.automotor.demo.model.Producto;
import com.automotor.demo.repository.ProductoRepository;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/api/v1/")
public class ProductoController {

	@Autowired
	private ProductoRepository productoRepository;
	
	
	@GetMapping("/productos")
	public List<Producto> getAllProductos(){
		return productoRepository.findAll();
	}
	
	@PostMapping("/crearProducto")
	public Producto createProducto(@RequestBody Producto producto) {
		return productoRepository.save(producto);
	}
	
	
	@GetMapping("/producto/{id}")
	public ResponseEntity<Producto> getProductId(@PathVariable Long id) {
		
		Producto producto = productoRepository.findById(id).orElseThrow();
		
		return ResponseEntity.ok(producto);
				
	}
	
	
	@PutMapping("/actualizarProducto/{id}")
	public ResponseEntity<Producto> updateProduct(@PathVariable Long id, @RequestBody Producto product){
		Producto producto = productoRepository.findById(id).orElseThrow();
		
		producto.setNombre(product.getNombre());
		producto.setCantidad(product.getCantidad());
		producto.setFechaIngreso(product.getFechaIngreso());
		producto.setUsuario(product.getUsuario());
		
		Producto updateProduct = productoRepository.save(producto);
		return ResponseEntity.ok(updateProduct);
		
	}
	
	
}
