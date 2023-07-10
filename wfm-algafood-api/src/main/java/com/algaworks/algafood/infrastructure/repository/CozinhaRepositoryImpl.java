package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

//Pincelada sobre  padrão Agregate e seu aAregate Root de uma instacia pricipal dentro de um domínio, e como uma 
//instancias de fora do dominio agregado devem referenciar o a classe de Agregate Root para manter a integridade

//https://www.amazon.com.br/Domain-Driven-Design-Eric-Evans/dp/8550800651
//https://martinfowler.com/bliki/DDD_Aggregate.html

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository{
	
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cozinha> listar() {		
//		TypedQuery<Cozinha> query =  manager.createQuery("from cozinha", Cozinha.class).getResultList();	
//		return query.getResultList();
		
		return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
	}
	
	
	@Override
	public Cozinha buscar(Long id) {
		return manager.find(Cozinha.class, id);
	}
	
	@Transactional  //indica que o metodo vai ser rodado dentro de uma transação
	@Override
	public Cozinha adicionar(Cozinha cozinha) {
		return manager.merge(cozinha);
	}
	
	@Transactional
	@Override
	public void remover(Cozinha cozinha) {
		cozinha = buscar(cozinha.getId());
		manager.remove(cozinha);
	}
}
