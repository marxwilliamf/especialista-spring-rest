package com.algaworks.algafood.domain.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
public class Permissao {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String descricao;	
	
	public static void listar(List<Permissao> permissoes) {
		for(Permissao permissao:permissoes) {
			permissao.printCmd();
		}
	}
	
	public void printCmd() {
		System.out.println(this.toString());
	}

	public Permissao(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	
}
