package com.algaworks.infrastructure.repository;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.WfmAlgafoodApiApplication;

public class NewApplication {

	protected static ApplicationContext applicationContext = new SpringApplicationBuilder(WfmAlgafoodApiApplication.class)
			.web(WebApplicationType.NONE)
			.run();
}
