package dev.paie.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import dev.paie.config.ServicesConfig;
import dev.paie.service.InitialiserDonneesService;

@Configuration
@EnableWebMvc
@ComponentScan("dev.paie.web.controller")
@Import({ServicesConfig.class, SecurityConfig.class})
@ImportResource({"classpath:grades.xml","classpath:entreprises.xml","classpath:profils-remuneration.xml","classpath:cotisations-imposables.xml","classpath:cotisations-non-imposables.xml"})
public class WebAppConfig {
	
	@Autowired
	InitialiserDonneesService init;
	
	@Bean
	public ViewResolver viewResolver() {
	return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");

	}
	
//	@PostConstruct
//	public void insererDonneInitialisation(){
//		
//		init.initialiserGrade();
//		init.intialiserEntreprise();
//	}

}
