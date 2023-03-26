package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.WfmAlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;

public class InclusaoCozinhaMain {

	public static void main(String[] args) {
		//Application context gerencia o contexto da aplicação Spring, não ´pe uma aplicação web 
		ApplicationContext applicationContext = new SpringApplicationBuilder(WfmAlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
		
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Brasileira");

		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Japonesa");

		//merge não atualiza cozinha1 por isso precisa pegar o return para setar a nova cozinha atualizada já com o Id Gerado
		cozinha1 = cadastroCozinha.cozinhaAdicionar(cozinha1); 
		cozinha2 = cadastroCozinha.cozinhaAdicionar(cozinha2);
		
		System.out.printf("%d - %s\n", cozinha1.getId(), cozinha1.getNome());
		System.out.printf("%d - %s\n", cozinha2.getId(), cozinha2.getNome());
	}
}
