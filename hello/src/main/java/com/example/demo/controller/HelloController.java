package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/helloangel")
public class HelloController {

@GetMapping
public String habilidade () {
	return ("Foco, Orientação aos Detalhes");
}
}
