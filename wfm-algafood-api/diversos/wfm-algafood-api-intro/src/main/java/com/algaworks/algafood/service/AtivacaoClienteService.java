package com.algaworks.algafood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.modelo.Cliente;


@Component //bean //componente gerenciado pelo spring que responde requisições web
public class AtivacaoClienteService{
	
	@Autowired
	private ApplicationEventPublisher eventPublisher; // padrão Obeservable, EventHandler
	
	public void ativar(Cliente cliente) {	
		cliente.ativar();
		
		eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
	}
}

//Digamos que no sistema teriamos centenas ou milhares de classes que usam notificador por email, e por algum motivo queira 
//trocar a notificação por SMS ou vice versa, as classes dessa forma estão altamente acopladas, e seria nessesário alterar 
//diversas classes que utilizassem esse notificador. 

//Essa é uma possível solução com menor acoplamento, 
//Pois ela possui:
//Baixo acoplamento, não depende mais de Notificador
//alta coesão, não está assumindo a responsabilidade de outra classe
//apenas publiba o evento que algo aconteceu
