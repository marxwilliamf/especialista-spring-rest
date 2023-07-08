package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.ResponseBody;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;


///////////////////////////////////
//C:\Windows\System32\drivers\etc\hosts
//127.0.0.1		api.algafood.local
//GET localhost:8080/cozinhas
//GET api.algafood.local:8080/cozinhas
///////////////////////////////////
// GET /cozinhas HTTP/1.1
///////////////////////////////////
//@Controller
//@ResponseBody
//Essas duas anotações podem ser trocadas por @RestControler
///////////////////////////////////

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {


	@Autowired
	CozinhaRepository cozinhaRepository;
	
	@GetMapping
	public List<Cozinha> listar() {
		return cozinhaRepository.todas();
	}
	
	
}
