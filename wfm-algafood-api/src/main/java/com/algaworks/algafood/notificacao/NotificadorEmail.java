package com.algaworks.algafood.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.modelo.Cliente;

//@Primary //faz a desambiguação de beans //quando tem mais de um para ser usado em uma mesma injeção o que tiver com o primary é que va ser usado
@Qualifier("normal") //("email") //poderia colocar email mas deixaria o sistema mais acoplado, em casos de mudanças
@Component
public class NotificadorEmail implements Notificador { //implements Notificador
	
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		
		System.out.printf("Notificando %s através do E-mail %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}

	
	
}