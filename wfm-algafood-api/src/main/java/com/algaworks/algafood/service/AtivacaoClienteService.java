package com.algaworks.algafood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.modelo.Cliente;
import com.algaworks.algafood.notificacao.Notificador;


@Component //bean //componente gerenciado pelo spring que responde requisições web
public class AtivacaoClienteService {

	@Autowired
	private Notificador notificador;
	
//	@Autowired //Define qual constreutor será usado, caso so tenho um construtor é opcional
//	public AtivacaoClienteService(Notificador notificador) {
//		this.notificador = notificador;
//		
//		System.out.println("AtivacaoClienteService: " + notificador);
//	}
//
//	public AtivacaoClienteService(String qualquer) { //Construtor 2
//		//qualquer coisa
//	}
	
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		this.notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	
	}
//
//	@Autowired //Não basta apenas setar precisa autoqired
//	public void setNotificador(Notificador notificador) {
//		this.notificador = notificador;
//	}
	
}

//Digamos que no sistema teriamos centenas ou milhares de classes que usam notificador por email, e por algum motivo queira 
//trocar a notificação por SMS ou vice versa, as classes dessa forma estão altamente acopladas, e seria nessesário alterar 
//diversas classes. A seguir será meolhorado um pouco o exemplo para mostrar uma possível solução com menor acoplamento, 
//com um tipo de injeção de dependência

//Nesse caso hipotético os notificadores não tem parametros no construtor, não há necessidade de configurações personalizadas
//tornando se fácil trocar a implementação em dois serviços, porém isso é apenas uma simulação de um caso real e requer 
//um pouco de imaginação.
