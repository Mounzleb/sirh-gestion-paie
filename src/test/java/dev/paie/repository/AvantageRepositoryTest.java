package dev.paie.repository;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;
import dev.paie.entite.Cotisation;

@ContextConfiguration(classes = { ServicesConfig.class })
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {

	@Autowired
	AvantageRepository avantageRepository;

	@Test

	public void test_sauvegarder_lister_mettre_a_jour() {

		System.out.println("nous sommes dans test_sauvegarder_lister_mettre_a_jour");
		// TODO sauvegarder un nouvel avantage
		Avantage newAvantage = new Avantage();
		// newAvantage.setId((int) (Math.random() * 100000));
		newAvantage.setCode("code");
		newAvantage.setNom("libelle");
		newAvantage.setMontant(new BigDecimal("3000.00"));

		System.out.println(newAvantage);
		avantageRepository.save(newAvantage);

		System.out.println("NOUVELLE AVANTAGE EFFECTUE");
// test de verification qu'on a bien eue la creation d'un nouvelle id
		int id = newAvantage.getId();
		assertTrue(id != 0);
		// TODO vérifier qu'il est possible de récupérer le nouvel avantage la
		// méthode findOne
		Avantage findAvantage = avantageRepository.findOne(id);
		System.out.println("Le nouvelle avantage ajouter à la table est " + findAvantage);
		// SANS LE TOSTRING() GENERER DANS LA CLASSE AVANTAGE:
		// dev.paie.entite.Avantage@4f8b4bd0
		// AVEC LE TOSTRING() GENERER DANS AVANTAGE IL M'AFIICHE : Le nouvelle
		// avantage ajouter à la table est Avantage [id=8523, code=code,
		// nom=libelle, montant=3000.00]

		// TODO modifier un avantage et tester si la modification sur le nom à bien etais faite
		//A VERIFIER SI IL VERIFIE BIEN  LE CHANGEMENT
		Avantage av2 = avantageRepository.findOne(5);
		av2.setNom("Hollaaaaa");
		avantageRepository.save(av2);
		assertTrue(avantageRepository.findOne(5).getNom().equals("Hollaaaaa"));
		
		// Voir pour faire la verification sur toute la base de donnée, car la il verifie uniquement pour un id donner ici dans notre cas c'est id=5

	}
}
