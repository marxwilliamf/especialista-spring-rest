package com.algaworks.infrastructure.repository;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;

public class PermissaoTest extends NewApplication{
	PermissaoRepository permissoes = applicationContext.getBean(PermissaoRepository.class);
	
	@Test
	public void todasPermissoes() {
		System.out.println("\n\n\nListando todas permissoes:");
		List<Permissao> todasPermissoes = permissoes.findAll();
		Permissao.listar(todasPermissoes);	
	}
	
	@Test
	public void encontrar1Permissao() {
		System.out.println("\n\n\nEncontrar Permissão\n");
		Permissao permissao = permissoes.findById(1L).get();
		permissao.printCmd();
	}
	
	@Test
	public void addicionarPermissao() {
		System.out.println("\n\n\nAdicionar Permissão\n");
		Permissao permissao = new Permissao("AgendarHorario", "Permite ao cliente agendar Horário");
		permissoes.save(permissao);
		
		todasPermissoes();
	}
	
	@Test
	public void removerPermissao() {
		System.out.println("\n\n\nRemovendo Permissão\n");
		permissoes.delete(permissoes.findById(10L).get());
		
		todasPermissoes();
	}
}