package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//ponto no endereço do site
@RequestMapping("/hello")
@RestController
public class ServicoController {
	
//@GetMapping("/get1")
//public String hello1() {
//	return "hey Get1 Hello World";
//}
//
//@GetMapping("/get2")
//public String hello2() {
//	return "Hey Get Hello World";
//}
	
//injeção
	@Autowired
	private ServicoRepository repository;
	
	@GetMapping ("/servicos")
	public List<ServicoModel> pegarTodos() {		
		return repository.findAll();
	}
	
	//post resp por inserir
	@PostMapping("/servicos")
	public ServicoModel criar(@RequestBody ServicoModel tabelaServico) {
		repository.save(tabelaServico);
		return tabelaServico;
	}
}


//mvc---- model (tables)
	//mvc---- view (front)
	//mvc---- controller (cerebro, endereçamento)
	//jpa é interface