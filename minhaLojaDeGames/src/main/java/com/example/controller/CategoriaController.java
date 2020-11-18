package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.model.CategoriaModel;
import com.example.repository.CategoriaRepository;

@RestController
@RequestMapping ("/categoria")
public class CategoriaController{
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping("/categoria")
	public List<CategoriaModel> buscarTodos() {		
		return repository.findAll();
	}
	
	@GetMapping("/categoria/id/{id}")
	public Optional<CategoriaModel> buscarUm(@PathVariable Long id) {
		return repository.findById(id);
	}
	
	@PostMapping("/categoria")
	public CategoriaModel criar(@RequestBody CategoriaModel categoria) {
		repository.save(categoria);
		return categoria;
}
	
}


