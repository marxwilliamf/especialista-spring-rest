package com.algaworks.algafood.api.controller;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;
import lombok.NonNull;


@JacksonXmlRootElement(localName = "cozinhas")  // = @JsonRootName("cozinhas")
@Data //Gera construtores Getters e setters
public class CozinhasXmlWrapper {

	@JacksonXmlProperty(localName = "cozinha")
	@JacksonXmlElementWrapper(useWrapping = false)
	@NonNull //Para incluir no construtor precisa deixar explicito desdsa forma
	List<Cozinha> cozinhas;
	
}
