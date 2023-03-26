package com.algaworks.algafood.jpa;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Cozinha;

@Component
public class CadastroCozinha {

	
		@PersistenceContext
		private EntityManager manager;
		
		public List<Cozinha> listar() {		
//			TypedQuery<Cozinha> query =  manager.createQuery("from cozinha", Cozinha.class).getResultList();	
//			return query.getResultList();
			
			return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
		}
		
		
		@Transactional  //indica que o metodo vai ser rodado dentro de uma transação
		public Cozinha cozinhaAdicionar(Cozinha cozinha) {
			return manager.merge(cozinha);
		}
		
		
}
