package com.algaworks.algafood.domain.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Estado {

	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
//	@OneToMany(mappedBy = "estado", fetch = FetchType.EAGER)
//	List<Cidade> cidades;
	
//	public void listarCidades() {
//		for(Cidade c:cidades) {
//			c.printCmd();
//		}
//	}
	
	
	
	public void printCmd() {
		System.out.println(this.toString());
	}
	
	public static void listar(List<Estado> todosEstados) {
		for(Estado estado: todosEstados) {
			estado.printCmd();
			//estado.listarCidades();
		}
	}



	@Override
	public String toString() {
		return "Estado => id: " + id + " - " + nome;
	}
	
}
