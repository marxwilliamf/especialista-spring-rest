package com.algaworks.infrastructure.repository;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

public class EstadoTest extends NewApplication{

	
	EstadoRepository estados = applicationContext.getBean(EstadoRepository.class);

	
	@Test
	public void todosEstados() {
		List<Estado> todosEstados = estados.findAll();
	
		System.out.println("\n\n\nListar Todos Estados:\\n\\n");
		Estado.listar(todosEstados);
	}
	
	@Test
	public void buscaPorId() {
		Estado estado = estados.findById(5L).get();
		
		System.out.println("\nBusca por Id Teste:");
		estado.printCmd();
		
	}
	
	@Test
	public void adicionar() {
		
		Estado estado = new Estado();
		estado.setNome("PR");

		System.out.println("\nAdicionar Estado Teste:");
		estados.save(estado);
		
		List<Estado> todosEstados = estados.findAll();
		Estado.listar(todosEstados);
	}
	
	@Test
	void atualizar() {
		
		Estado estado = estados.findById(6L).get();
		estado.setNome("PR");

		System.out.println("\nAtualizar por Id Teste:");
		estados.save(estado);
		
		List<Estado> todosEstados = estados.findAll();
		Estado.listar(todosEstados);
		
	}
	
	@Test
	public void remove() {
		Estado estado = new Estado();
		estado.setId(2L);
		
		System.out.println("\nRemover Estado Teste:");
		estados.deleteById(estado.getId());
		
		List<Estado> todosEstados = estados.findAll();
		Estado.listar(todosEstados);
	}
	
}
