package dev.paie.service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.User;

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
		
		
		User user1 = new User(1, "user1","password1");
		User user2 = new User(2, "user2", "password2");
		User user3 = new User(3, "user3", "password3");
		context.getBeansOfType(Grade.class).forEach((idGrade, grade) -> em.persist(grade));
		context.getBeansOfType(Entreprise.class).forEach((idEntreprise, entreprise) -> em.persist(entreprise));
		context.getBeansOfType(ProfilRemuneration.class).forEach((idprofRem, profRem) -> em.persist(profRem));
		context.getBeansOfType(Cotisation.class).forEach((idCotis, cotisation) -> em.persist(cotisation));

		/*
		 * générer les données de périodes : 12 périodes programmatiquement de
		 * l’année courante.
		 */
		for (int mois = 1; mois < 13; mois++) {
			LocalDate aujourdhui = LocalDate.now();
			LocalDate localdate = LocalDate.of(aujourdhui.getYear(), mois, 1);
			em.persist(new Periode(localdate, localdate.with(TemporalAdjusters.lastDayOfMonth())));
		}

	}

}
