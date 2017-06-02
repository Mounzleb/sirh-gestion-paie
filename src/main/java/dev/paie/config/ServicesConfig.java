package dev.paie.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import dev.paie.spring.DataSourceMySQLConfig;
import dev.paie.spring.JpaConfig;

@Configuration
// Cette configuration permet de rechercher des beans Spring dans le package
// dev.paie.service.
@ComponentScan({ "dev.paie.service", "dev.paie.util" })
@Import({ JpaConfig.class, DataSourceMySQLConfig.class })
// j'aurais pu mettre dans le @ComponentScan le package dev.paie.spring, ainsi
// il scnann les deux classe ci-dessus.
@EnableJpaRepositories("dev.paie.repository")
public class ServicesConfig {

}
