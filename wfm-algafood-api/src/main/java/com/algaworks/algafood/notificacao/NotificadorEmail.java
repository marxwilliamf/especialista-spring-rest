package com.algaworks.algafood.notificacao;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.modelo.Cliente;

@Component //assim temos um bean spring definido e gerenciado pelo IoC Container
public class NotificadorEmail implements Notificador { //implements Notificador
	
	public NotificadorEmail() { //com o @Component a classe é instanciada dentro do container na inicialização do sistema 
								//junto com vários outros beans pertencentes ao sistema Spring
		System.out.println("NotificadorEmail");
	}
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s através do E-mail %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}
	
}