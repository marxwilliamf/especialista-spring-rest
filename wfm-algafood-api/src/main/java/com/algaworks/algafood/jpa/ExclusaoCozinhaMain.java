package com.algaworks.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.algaworks.algafood.WfmAlgafoodApiApplication;
import com.algaworks.algafood.domain.execption.EntidadeEmUsoException;
import com.algaworks.algafood.domain.execption.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;

public class ExclusaoCozinhaMain {

	public static void main(String[] args) {
		//Application context gerencia o contexto da aplicação Spring, não ´pe uma aplicação web 
		ApplicationContext applicationContext = new SpringApplicationBuilder(WfmAlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroCozinhaService cozinhas = applicationContext.getBean(CadastroCozinhaService.class);
		
		
		Long cozinhaId = 1L;
		
		try {
			cozinhas.excluir(cozinhaId);
		} catch(EntidadeNaoEncontradaException e) {
			System.out.println("\n\n" + e.getMessage() + "\n\n");
		} catch(EntidadeEmUsoException e) {
			System.out.println("\n\n" + e.getMessage() + "\n\n");
		}
		
	
	}
}
