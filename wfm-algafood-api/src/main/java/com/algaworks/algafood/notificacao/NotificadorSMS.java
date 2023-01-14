package com.algaworks.algafood.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.modelo.Cliente;

@Qualifier("urgente") //("sms") poderia colocar sms mas deixaria o sistema mais acoplado, em casos de mudanças
@Component
public class NotificadorSMS implements Notificador { //implements Notificador
		
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s por SMS atraves do tellefone %s: %s\n", cliente.getNome(), cliente.getTelefone(), mensagem);
	}	
}