package com.algaworks.infrastructure.repository;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

public class EstadoTest extends NewApplication{

	
	EstadoRepository estados = applicationContext.getBean(EstadoRepository.class);

	
	@Test
	public void todosEstados() {
		List<Estado> todosEstados = estados.todos();
	
		System.out.println("\n\n\nListar Todos Estados:\\n\\n");
		Estado.listar(todosEstados);
	}
	
	@Test
	public void buscaPorId() {
		Estado estado = estados.porId(5L);
		
		System.out.println("\nBusca por Id Teste:");
		estado.printCmd();
		
	}
	
	@Test
	public void adicionar() {
		
		Estado estado = new Estado();
		estado.setNome("PR");

		System.out.println("\nAdicionar Estado Teste:");
		estados.adicionar(estado);
		
		List<Estado> todosEstados = estados.todos();
		Estado.listar(todosEstados);
	}
	
	@Test
	void atualizar() {
		
		Estado estado = estados.porId(6L);
		estado.setNome("PR");

		System.out.println("\nAtualizar por Id Teste:");
		estados.adicionar(estado);
		
		List<Estado> todosEstados = estados.todos();
		Estado.listar(todosEstados);
		
	}
	
	@Test
	public void remove() {
		Estado estado = new Estado();
		estado.setId(2L);
		
		System.out.println("\nRemover Estado Teste:");
		estados.remover(estado);
		
		List<Estado> todosEstados = estados.todos();
		Estado.listar(todosEstados);
	}
	
}
