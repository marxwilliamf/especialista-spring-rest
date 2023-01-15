package com.algaworks.algafood.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.modelo.Cliente;
import com.algaworks.algafood.modelo.NivelUrgencia;
import com.algaworks.algafood.modelo.TipoDoNotificador;
import com.algaworks.algafood.notificacao.Notificador;


@Component //bean //componente gerenciado pelo spring que responde requisições web
public class AtivacaoClienteService implements InitializingBean, DisposableBean{
	
	@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
	@Autowired(required = false)
	private Notificador notificador; //Recebe uma lista de notificadores
	
//	//@PostConstruct  //callback
//	public void init () {
//		System.out.println("INIT " + notificador);
//	}
//	
//	//@PreDestroy  //callback
//	public void destroy () {
//		System.out.println("DESTROY");
//	}
	
	public void ativar(Cliente cliente) {
	
		cliente.ativar();
		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DESTROY");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("INIT " + notificador);
		
	}	
}

//Digamos que no sistema teriamos centenas ou milhares de classes que usam notificador por email, e por algum motivo queira 
//trocar a notificação por SMS ou vice versa, as classes dessa forma estão altamente acopladas, e seria nessesário alterar 
//diversas classes. A seguir será meolhorado um pouco o exemplo para mostrar uma possível solução com menor acoplamento, 
//com um tipo de injeção de dependência

//Nesse caso hipotético os notificadores não tem parametros no construtor, não há necessidade de configurações personalizadas
//tornando se fácil trocar a implementação em dois serviços, porém isso é apenas uma simulação de um caso real e requer 
//um pouco de imaginação.
