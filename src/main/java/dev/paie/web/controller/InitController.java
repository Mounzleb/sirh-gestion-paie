package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import dev.paie.service.InitialiserDonneesService;

@Component
public class InitController implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired private InitialiserDonneesService initDonne;
	
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent ) {
//    	initDonne.initialiserGrade();
    	System.out.println("Contexte créé " + initDonne);
    	
    	initDonne.initialiserGrade();
    	initDonne.intialiserEntreprise();
    	initDonne.initialiserCotisation();
    	initDonne.initialiserProfilsRemunerations();

    }
}