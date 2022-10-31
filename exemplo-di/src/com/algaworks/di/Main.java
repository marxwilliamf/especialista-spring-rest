package com.algaworks.di;

import java.math.BigDecimal;

import com.algaworks.di.modelo.Cliente;
import com.algaworks.di.modelo.Produto;
import com.algaworks.di.service.AtivacaoClienteService;
import com.algaworks.di.service.EmissaoNotaFiscalService;

public class Main {
	public static void main(String[] args) {
		Cliente joao = new Cliente("João", "joao@xyz.com", "88554699");
		Cliente maria = new Cliente("Maria", "maria@xyz.com", "88554699");
		
		AtivacaoClienteService ativacaoCliente = new AtivacaoClienteService();
		ativacaoCliente.ativarCliente(joao);
		ativacaoCliente.ativarCliente(maria);
	
//	Produto produto =  new Produto("Curso", new BigDecimal(1500));
//	EmissaoNotaFiscalService emissor = new EmissaoNotaFiscalService();
//	emissor.emitir(maria, produto);
	
	}
}
