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
	public void initialiserGrade() {

		/*
		 * Recuperation les bean du grades.xml par une map (sorte de liste qui
		 * est faite en (index,objet) autres que le .map des stram) Puis
		 * j'applique un foreach pour boucler et recupérer tous les beans de
		 * grade.xml
		 */
		List<Grade> listeGrade = new ArrayList<>();
		listeGrade.addAll(context.getBeansOfType(Grade.class).values());

		context.getBeansOfType(Grade.class).forEach((idGrade, grade) -> em.persist(grade));
	}

	@Override
	@Transactional
	public void intialiserEntreprise() {
		List<Entreprise> listEntreprise = new ArrayList<>();
		listEntreprise.addAll(context.getBeansOfType(Entreprise.class).values());

		context.getBeansOfType(Entreprise.class).forEach((idEntreprise, entreprise) -> em.persist(entreprise));

	}

	@Override
	@Transactional
	public void initialiserCotisation() {
		List<Cotisation> listCotisation = new ArrayList<>();
		listCotisation.addAll(context.getBeansOfType(Cotisation.class).values());

		context.getBeansOfType(Cotisation.class).forEach((idCotis, cotisation) -> em.persist(cotisation));		
	}


	@Override
	@Transactional
	public void initialiserProfilsRemunerations() {
		List<ProfilRemuneration> listProfilRemuneration = new ArrayList<>();
		listProfilRemuneration.addAll(context.getBeansOfType(ProfilRemuneration.class).values());

		context.getBeansOfType(ProfilRemuneration.class).forEach((idprofRem, profRem) -> em.persist(profRem));		
	}

}
