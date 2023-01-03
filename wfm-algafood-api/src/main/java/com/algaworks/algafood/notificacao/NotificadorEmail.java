package com.algaworks.algafood.notificacao;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.modelo.Cliente;

//@Component //Agora esta declarado dentro de AlgaConfig
public class NotificadorEmail implements Notificador { //implements Notificador
	
	
	private boolean caixaAlta;
	private String hostServidorSmtp;
	
	public NotificadorEmail(String hostServidorSmtp) { //com o @Component a classe é instanciada dentro do container na inicialização do sistema
								//junto com vários outros beans pertencentes ao sistema Spring
		this.hostServidorSmtp = hostServidorSmtp;
		System.out.println("NotificadorEmail");
	}
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		if(	this.caixaAlta) {
			mensagem = mensagem.toUpperCase();
		}
		
		System.out.printf("Notificando %s através do E-mail %s usando SMTP %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), this.hostServidorSmtp, mensagem);
	}

	public void setCaixaAlta(boolean caixaAlta) {
		this.caixaAlta = caixaAlta;
	}
	
}