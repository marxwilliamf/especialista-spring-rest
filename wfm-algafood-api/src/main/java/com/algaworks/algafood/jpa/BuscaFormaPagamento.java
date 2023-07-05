package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.WfmAlgafoodApiApplication;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

public class BuscaFormaPagamento {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(WfmAlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		FormaPagamentoRepository formaPagamentoRepository = applicationContext.getBean(FormaPagamentoRepository.class);
		
		List<FormaPagamento> formasDePagamento = formaPagamentoRepository.todas();
		
		
		for(FormaPagamento f:formasDePagamento) {
			System.out.printf("%d - %s\n", f.getId(), f.getDescricao());
		}
		
		}
}
