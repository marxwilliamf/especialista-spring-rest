package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {

	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Cozinha salvar(Cozinha  cozinha) {
		//Aqui poderia ter uma regra de negócia por exemplo só poder criar uma cozinha em dia útil
		// é claro ipotéticamente falando
		
		return cozinhaRepository.salvar(cozinha);
	}
	
	
	
}
