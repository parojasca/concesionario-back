package com.automotor.demo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.automotor.demo.model.Producto;
import com.automotor.demo.model.Usuario;
import com.automotor.demo.repository.ProductoRepository;

@SpringBootApplication
public class SpringbootAutomotorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAutomotorApplication.class, args);
		
		
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/v1/").allowedOrigins("http://localhost:8080");
			}
		};
	}
	
	

}
