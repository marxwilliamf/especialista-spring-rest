package com.algaworks.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.WfmAlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;

public class ExclusaoCozinhaMain {

	public static void main(String[] args) {
		//Application context gerencia o contexto da aplicação Spring, não ´pe uma aplicação web 
		ApplicationContext applicationContext = new SpringApplicationBuilder(WfmAlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
		
		
		Cozinha cozinha = new Cozinha();
		cozinha.setId(1L);


		//merge não atualiza cozinha1 por isso precisa pegar o return para setar a nova cozinha atualizada já com o Id Gerado
		cadastroCozinha.remover(cozinha); 
	
	}
}
