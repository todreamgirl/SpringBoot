package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.CategoriaModel;
import com.example.model.JogosModel;
import com.example.repository.CategoriaRepository;
import com.example.repository.JogosRepository;

public class JogosController {
	@Autowired
	private JogosRepository repository;
	
	@GetMapping("/jogos")
	public List<JogosModel> buscarTodos() {		
		return repository.findAll();
	}
	
	@GetMapping("/jogos/id/{id}")
	public Optional<JogosModel> buscarUm(@PathVariable Long id) {
		return repository.findById(id);
	}
	
	@PostMapping("/jogos")
	public JogosModel criar(@RequestBody JogosModel jogos) {
		repository.save(jogos);
		return jogos;

}
}
