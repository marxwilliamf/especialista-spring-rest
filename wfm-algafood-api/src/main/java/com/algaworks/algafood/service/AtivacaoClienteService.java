package com.algaworks.algafood.service;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.modelo.Cliente;
import com.algaworks.algafood.notificacao.NotificadorEmail;


@Component //bean //componente gerenciado pelo spring que responde requisições web
public class AtivacaoClienteService {

	private NotificadorEmail notificador;
	
	public void ativar(Cliente cliente) {
		
		cliente.ativar();
		
		this.notificador.notificar(cliente, "Seu cadastro no sistema est� ativo!");
	
	}
	
}

//Digamos que no sistema teriamos centenas ou milhares de classes que usam notificador por email, e por algum motivo queira 
//trocar a notifica��o por SMS ou vice versa, as classes dessa forma est�o altamente acopladas, e seria nesses�rio alterar 
//diversas classes. A seguir sera meolhorado um pouco o exemplo para mostrar uma poss�vel solu��o com menor acoplamento, 
//com um tipo de inje��o de depend�ncia

//Nesse caso hipot�tico os notificadores n�o tem parametros no construtor, n�o h� necessidade de configura��es personalizadas
//tornando se f�cil trocar a implementa��o em dois servi�os, por�m isso � apenas uma simula��o de um caso real e requer 
//um pouco de imagina��o.
