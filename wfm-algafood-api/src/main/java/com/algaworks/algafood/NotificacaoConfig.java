package com.algaworks.algafood;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.algafood.notificacao.NotificadorEmail;

@Configuration
public class NotificacaoConfig {

	@Bean //Dentro do IoC Container, por padão o bean será nomeado como "notificadorEmail", que é exatamente o nome do método de definição do Bean
	public NotificadorEmail notificadorEmail() {
		NotificadorEmail notificador = new NotificadorEmail("smtp.algamail.com.br");
		notificador.setCaixaAlta(true);

		return notificador;
	}
	
}
