package com.objetivos.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/semanal")
public class OSemanal {
	@GetMapping
	public String osemanal () {
		return ("Aprender MySql e SpringBoot");
	}

}
