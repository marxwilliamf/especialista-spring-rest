package com.algaworks.di.service;

import com.algaworks.di.modelo.Cliente;
import com.algaworks.di.notificacao.NotificadorEmail;
import com.algaworks.di.notificacao.NotificadorSMS;

public class AtivacaoClienteService {

	public void ativarCliente(Cliente cliente) {
		
		cliente.ativar();
		
//		NotificadorEmail notificador = new NotificadorEmail();
		NotificadorSMS notificador = new NotificadorSMS();
		
		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	
	}
	
}

//Digamos que no sistema teriamos centenas ou milhares de classes que usam notificador por email, e por algum motivo queira 
//trocar a notificação por SMS ou vice versa, as classes dessa forma estão altamente acopladas, e seria nessesário alterar 
//diversas classes. A seguir sera meolhorado um pouco o exemplo para mostrar uma possível solução com menor acoplamento, 
//com um tipo de injeção de dependência

//Nesse caso hipotético os notificadores não tem parametros no construtor, não há necessidade de configurações personalizadas
//tornando se fácil trocar a implementação em dois serviços, porém isso é apenas uma simulação de um caso real e requer 
//um pouco de imaginação.