package com.algaworks.infrastructure.repository;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class RestauranteTest extends NewApplication{

	
	RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);

	
	@Test
	public void todosRestaurantes() {
		List<Restaurante> todosRestaurantes = restaurantes.listar();
	
		System.out.println("\nListar Todos Teste:");
		listarRestaurantes(todosRestaurantes);
	}
	
	public void listarRestaurantes(List<Restaurante> todosRestaurantes) {
		for(Restaurante restaurante: todosRestaurantes) {
			System.out.println(restaurante.toString());
		}
	}
	
	@Test
	public void buscaPorId() {
		Restaurante restaurante = restaurantes.buscar(2L);
		
		System.out.println("\nBusca por Id Teste:");
		System.out.println(restaurante.toString());
	}
	
	@Test
	public void adicionar() {
		
		Restaurante restaurante = new Restaurante();
		restaurante.setNome("Gaúcho");
		restaurante.setTaxaFrete(new BigDecimal(23));

		System.out.println("\nAdicionar Restaurante Teste:");
		restaurantes.adicionar(restaurante);
		
		List<Restaurante> todosRestaurantes = restaurantes.listar();
		listarRestaurantes(todosRestaurantes);
	}
	
	@Test
	void atualizar() {
		
		Restaurante restaurante = restaurantes.buscar(2L);
		restaurante.setNome("Churrasco Gaúcho");

		System.out.println("\nAtualizar por Id Teste:");
		restaurantes.adicionar(restaurante);
		
		List<Restaurante> todosRestaurantes = restaurantes.listar();
		listarRestaurantes(todosRestaurantes);
		
	}
	
	@Test
	public void remove() {
		Restaurante restaurante = new Restaurante();
		restaurante.setId(1L);
		
		System.out.println("\nRemover Restaurante Teste:");
		restaurantes.remover(restaurante);
		
		List<Restaurante> todosRestaurantes = restaurantes.listar();
		listarRestaurantes(todosRestaurantes);
	}
	
}
