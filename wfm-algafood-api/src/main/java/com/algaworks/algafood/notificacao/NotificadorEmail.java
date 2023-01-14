package com.algaworks.algafood.notificacao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.modelo.Cliente;

@Primary //faz a desambiguação de beans //quando tem mais de um para ser usado em uma mesma injeção o que tiver com o primary é que va ser usado
@Component
public class NotificadorEmail implements Notificador { //implements Notificador
	
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		
		System.out.printf("Notificando %s através do E-mail %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}

	
	
}