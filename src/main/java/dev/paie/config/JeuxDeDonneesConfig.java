package dev.paie.config;

import org.springframework.context.annotation.ImportResource;

//Import de la configuration XML dans une configuration Java, donc possibilité d'utilisation de tout les bean précedement fait dans jdd-config.xml
@ImportResource("classpath:jdd-config.xml")
public class JeuxDeDonneesConfig {

}
