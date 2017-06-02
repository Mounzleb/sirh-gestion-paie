package dev.paie.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	/*
	 * On instancie un objet de la classe ApplicationContext, ainsi on recupére
	 * tout nos bean grâce au context
	 */
	@Autowired
	ApplicationContext context;

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public void initialiserDonne() {
		context.getBeansOfType(Grade.class).forEach((idGrade, grade) -> em.persist(grade));
		context.getBeansOfType(Entreprise.class).forEach((idEntreprise, entreprise) -> em.persist(entreprise));
		context.getBeansOfType(ProfilRemuneration.class).forEach((idprofRem, profRem) -> em.persist(profRem));
		context.getBeansOfType(Cotisation.class).forEach((idCotis, cotisation) -> em.persist(cotisation));

	}

}
