package com.algaworks.di;


import com.algaworks.di.modelo.Cliente;
//import com.algaworks.di.modelo.Produto;
//import java.math.BigDecimal;
import com.algaworks.di.notificacao.Notificador;
import com.algaworks.di.notificacao.NotificadorEmail;
//import com.algaworks.di.notificacao.NotificadorSMS;
import com.algaworks.di.service.AtivacaoClienteService;
//import com.algaworks.di.service.EmissaoNotaFiscalService;

public class Main {
	public static void main(String[] args) {
		Cliente joao = new Cliente("João", "joao@xyz.com", "88554699"); //3499998888
		Cliente maria = new Cliente("Maria", "maria@xyz.com", "88554699"); //1177772222
		
		Notificador notificador = new NotificadorEmail(); //new NotificadorSMS();
		
		AtivacaoClienteService ativacaoCliente = new AtivacaoClienteService(notificador);
		ativacaoCliente.ativarCliente(joao);
		ativacaoCliente.ativarCliente(maria);
	
//	Produto produto =  new Produto("Curso", new BigDecimal(1500));
//	EmissaoNotaFiscalService emissor = new EmissaoNotaFiscalService();
//	emissor.emitir(maria, produto);
	
	}
}
