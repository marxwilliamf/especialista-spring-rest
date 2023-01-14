package com.algaworks.algafood.notificacao;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.modelo.Cliente;

@Component
public class NotificadorSMS implements Notificador { //implements Notificador
		
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s por SMS atraves do tellefone %s: %s\n", cliente.getNome(), cliente.getTelefone(), mensagem);
	}	
}