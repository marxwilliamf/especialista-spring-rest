package com.algaworks.algafood.notificacao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.modelo.Cliente;
import com.algaworks.algafood.modelo.NivelUrgencia;
import com.algaworks.algafood.modelo.TipoDoNotificador;

@Profile("dev")
@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmailMock implements Notificador { //implements Notificador
	
	public NotificadorEmailMock() {
		System.out.println("NotificadorEmail MOCK");
	}

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		
		System.out.printf("Mock: Notificaçao seria enviada para %s através do E-mail %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}

	
	
}