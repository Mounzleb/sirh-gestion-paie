package dev.paie.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// Cette configuration permet de rechercher des beans Spring dans le package
// dev.paie.service.
@ComponentScan("dev.paie.service")
public class ServicesConfig {

}
