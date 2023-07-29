package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
