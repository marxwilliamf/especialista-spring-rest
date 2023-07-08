package com.algaworks.algafood.domain.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Cidade {

	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@ManyToOne  //(fetch = FetchType.EAGER)
	@JoinColumn(name = "estado_id", foreignKey = @ForeignKey(name = "fk_cidade_estado"), nullable = false)
	Estado estado;


	public void printCmd() {
		System.out.printf("%d - %s\n", this.getId(), this.getNome());	
	}
	
	public static void listar(List<Cidade> todosCidades) {
		for(Cidade cidade: todosCidades) {
			cidade.printCmd();
		}
	}
}
