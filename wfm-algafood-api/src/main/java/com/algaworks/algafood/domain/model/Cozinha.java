package com.algaworks.algafood.domain.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonRootName("cozinha") //Cozinha com c minusculo, muda o campo no XML, e no Json quando for um objeto interno//@JsonRootName("Gastronomia")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity///
public class Cozinha {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@JsonIgnore
	//@JsonProperty("titulo") //muda representação de nome para titulo
	@Column(nullable = false)
	private String nome;
	
//	@OneToMany(mappedBy = "cozinha")  isso não estava na aula
//	private List<Restaurante> restaurantes;
}
