package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@RestController
@RequestMapping
public class Controller implements WebMvcConfigurer {
	//Para acessar a pagina pelo localhost:8080
	public void addViewControllers(ViewControllerRegistry index) {
		index.addViewController("/").setViewName("forward:/index.html");
	}
	
	//injeção
	@Autowired
	private ManutencaoRepository repository;
	
	//localhost:8080/manutencoes
		@GetMapping ("/manutencoes")
	public List<ManutencaoTable> buscarTodos() {		
			return repository.findAll();
		}
		@Autowired
		private Services service;
		
		@GetMapping("/teste")
	    public ResponseEntity<List<ManutencaoTable>> listAllItens() {
	        List<ManutencaoTable> itens= service.findAllItens();
	        if(itens.isEmpty()){
	            return new ResponseEntity<List<ManutencaoTable>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<ManutencaoTable>>(itens, HttpStatus.ACCEPTED);
	    }

		
		
//		//deste jeito nao retornar erro
//		@GetMapping("/manutencoes/id/{id}")
//		public Optional<ManutencaoTable> buscarUm(@PathVariable Long id) {
//			return repository.findById(id);
//		}
			
			@GetMapping("/manutencoes/id/{id}")
			public ResponseEntity<ManutencaoTable> getById(@PathVariable Long id){
				return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
						.orElse(ResponseEntity.notFound().build());
			}

//		
//		//post resp por inserir
		
	@PostMapping("/manutencoes")
		public ManutencaoTable criar(@RequestBody ManutencaoTable objetinho) {
			repository.save(objetinho);
			return objetinho;
	}
	
	
	//put serve para atualiz, first with @PathVariable after @Requestbody
	
	@PutMapping("/manutencoes/{id}")
	public ManutencaoTable atualizar (@PathVariable Long id, @RequestBody ManutencaoTable objetinho) {
		objetinho.setId(id);
		repository.save(objetinho);
		return objetinho;
	}
	@GetMapping ("/manutencoes/test/{nome}")
	public List<ManutencaoTable> buscarUm(@PathVariable String nome){
		return repository.findByNome (nome);
		
		
			
		}
	@GetMapping ("/manutencoes/{nome}/{categoria}")
	public Optional<ManutencaoTable> findByNomeAndCategoria (@PathVariable String nome, @PathVariable String categoria){
		return repository.findByNomeAndCategoria(nome, categoria);
	}
	
	@DeleteMapping("manutencao/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	
}

