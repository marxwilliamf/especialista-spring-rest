package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//nullable = false é usado somente para criar o DDL, não é um validador, mas enquanto a estrutura do banco for criada pelo código, esse campo não aceitará null
	@Column(nullable = false)  
	private String nome;
	
	@Column(name = "taxa_frete", nullable = false)  //esse name é desnecessário pois ele já coloca o underscore automático
	private BigDecimal taxaFrete;	
	
	@ManyToOne
	@JoinColumn(name =  "cozinha_id", foreignKey = @ForeignKey(name = "fk_restaurante_cozinha")) // cozinha_id seria já o nome por padrão
	private Cozinha cozinha;
	
}
