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
		List<Restaurante> todosRestaurantes = restaurantes.findAll();
	
		System.out.println("\nListar Todos Teste:");
		Restaurante.listarRestaurantes(todosRestaurantes);
	}
	
	@Test
	public void buscaPorId() {
		Restaurante restaurante = restaurantes.findById(2L).get();
		
		System.out.println("\nBusca por Id Teste:");
		System.out.println(restaurante.toString());
	}
	
	@Test
	public void adicionar() {
		
		Restaurante restaurante = new Restaurante();
		restaurante.setNome("Gaúcho");
		restaurante.setTaxaFrete(new BigDecimal(23));

		System.out.println("\nAdicionar Restaurante Teste:");
		restaurantes.save(restaurante);
		
		List<Restaurante> todosRestaurantes = restaurantes.findAll();
		Restaurante.listarRestaurantes(todosRestaurantes);
	}
	
	@Test
	void atualizar() {
		
		Restaurante restaurante = restaurantes.findById(2L).get();
		restaurante.setNome("Churrasco Gaúcho");

		System.out.println("\nAtualizar por Id Teste:");
		restaurantes.save(restaurante);
		
		List<Restaurante> todosRestaurantes = restaurantes.findAll();
		Restaurante.listarRestaurantes(todosRestaurantes);
		
	}
	
	@Test
	public void remove() {
		List<Restaurante> todosRestaurantes = restaurantes.findAll();
		Restaurante.listarRestaurantes(todosRestaurantes);
		
		Restaurante restaurante = new Restaurante();
		restaurante.setId(1L);
		
		System.out.println("\nRemover Restaurante Teste:");
		restaurantes.delete(restaurante);
		
		todosRestaurantes = restaurantes.findAll();
		Restaurante.listarRestaurantes(todosRestaurantes);
	}
	
}
