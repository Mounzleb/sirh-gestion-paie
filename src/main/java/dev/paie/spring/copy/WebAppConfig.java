package dev.paie.spring.copy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import dev.paie.config.ServicesConfig;

@Configuration
@EnableWebMvc
@ComponentScan("dev.paie.web.controller")
@Import(ServicesConfig.class)
public class WebAppConfig {
	
	@Bean
	public ViewResolver viewResolver() {
	return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");

	}

}
