package com.algaworks.infrastructure.repository;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;

public class CidadeTest extends NewApplication{

	
	CidadeRepository cidades = applicationContext.getBean(CidadeRepository.class);
	EstadoRepository estados = applicationContext.getBean(EstadoRepository.class);

	
	@Test
	public void todosCidades() {
		List<Cidade> todasCidades = cidades.findAll();
	
		System.out.println("\n\n\nListar Todos Teste:\\n\\n");
		Cidade.listar(todasCidades);
	}
	
	@Test
	public void buscaPorId() {
		Cidade cidade = cidades.findById(2L).get(); //Não recomendável fazer essa get em produção
		
		System.out.println("\nBusca por Id Teste:");
		cidade.printCmd();
	}
	
	@Test
	public void adicionar() {
		
		Cidade cidade = new Cidade();
		cidade.setNome("Copacabana");
		Estado estado = estados.buscar(5L);
		cidade.setEstado(estado);

		System.out.println("\nAdicionar Cidade Teste:");
		cidades.save(cidade);
		
		List<Cidade> todosCidades = cidades.findAll();
		Cidade.listar(todosCidades);
	}
	
	@Test
	void atualizar() {
		
		Cidade cidade = cidades.findById(2L).get();
		cidade.setNome("Gramado RS");

		System.out.println("\nAtualizar por Id Teste:");
		cidades.save(cidade);
		
		List<Cidade> todosCidades = cidades.findAll();
		Cidade.listar(todosCidades);
		
	}
	
	@Test
	public void remove() {
		Cidade cidade = new Cidade();
		cidade.setId(4L);
		
		System.out.println("\nRemover Cidade Teste:");
		cidades.deleteById(cidade.getId());
		
		List<Cidade> todosCidades = cidades.findAll();
		Cidade.listar(todosCidades);
	}
	
}
