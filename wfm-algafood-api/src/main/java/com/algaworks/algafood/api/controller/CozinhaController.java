package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)  //tanto faz usar a constante ou escrever, mas é mais recomandável constante //(produces = "application/json")
	public List<Cozinha> listar1() {
		return cozinhaRepository.listar();
	}
	
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CozinhasXmlWrapper listar2() {
		return new CozinhasXmlWrapper(cozinhaRepository.listar());
	}

	@ResponseStatus(HttpStatus.CREATED) //caso queira modificar o código de status, porém 201 não é o correto para essa requisição
	@GetMapping("/{cozinhaId}")
	public Cozinha buscar(@PathVariable Long cozinhaId) { // = //(@PathVariable("cozinhaId") Long id) { 
		return cozinhaRepository.buscar(cozinhaId);
	}
	
	
}
