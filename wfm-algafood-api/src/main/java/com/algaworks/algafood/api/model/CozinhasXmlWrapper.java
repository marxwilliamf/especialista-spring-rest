//package com.algaworks.algafood.api.model;
//
//import java.util.List;
//
//import com.algaworks.algafood.domain.model.Cozinha;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonRootName;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
////import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
////import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
//
//import lombok.Data;
//import lombok.NonNull;
//
///*
// * @JacksonXmlRootElement é uma alternativa à @JsonRootElement e
// * @JacksonXmlProperty à @JsonProperty.
// * 
// * A diferença é que as anotações iniciadas com @JacksonXml só afetam
// * a serialização em XML. Já as anotações iniciadas com @Json
// * afetam tanto a serialização JSON como também XML.
// */
//
//
//@JsonRootName("cozinhas")
////@JacksonXmlRootElement(localName = "cozinhas")  // = @JsonRootName("cozinhas")
//@Data //Gera construtores Getters e setters
//public class CozinhasXmlWrapper {
//
//	@JsonProperty("cozinha")
////	@JacksonXmlProperty(localName = "cozinha")
//	@JacksonXmlElementWrapper(useWrapping = false)
//	@NonNull //Para incluir no construtor precisa deixar explicito desdsa forma
//	List<Cozinha> cozinhas;
//	
//}
