package com.algaworks.algafood.notificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.modelo.Cliente;
import com.algaworks.algafood.modelo.NivelUrgencia;
import com.algaworks.algafood.modelo.TipoDoNotificador;


@Profile("prod")
@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmail implements Notificador { //implements Notificador
	
	@Autowired
	NotificadorProperties properties;
	
	public NotificadorEmail() {
		System.out.println("NotificadorEmail REAL");
	}
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.println("Host: " + properties.getHostServidor());
		System.out.println("Porta: " + properties.getPortaServidor());
		
		System.out.printf("Notificando %s através do E-mail %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}

	
	
}