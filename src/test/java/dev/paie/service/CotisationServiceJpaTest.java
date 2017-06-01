package dev.paie.service;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;

//TODO compléter la configuration
//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ServicesConfig.class })
// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
// test
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {

	@Autowired
	private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder une nouvelle cotisation
		System.out.println("nous sommes dans test_sauvegarder_lister_mettre_a_jour");
		Cotisation newcotisation = new Cotisation();
		newcotisation.setId((int) (Math.random() * 100000));
		newcotisation.setCode("code");
		newcotisation.setLibelle("libelle");
		newcotisation.setTauxPatronal(new BigDecimal("15"));
		newcotisation.setTauxSalarial(new BigDecimal("30"));
		System.out.println(newcotisation);
		cotisationService.sauvegarder(newcotisation);
		System.out.println(cotisationService);

		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation
		// via laméthode lister
		boolean bool = false;
		List<Cotisation> listcoti = cotisationService.lister();
		for (Cotisation gr : listcoti) {
			if (gr.getCode().equals(newcotisation.getCode())) {
				bool = true;
			}

		}
		assertTrue(bool);
		// TODO modifier une cotisation
		newcotisation.setCode("abdel");
		cotisationService.mettreAJour(newcotisation);
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister
		List<Cotisation> listcotiapresmodif = cotisationService.lister();
		for (Cotisation gr : listcotiapresmodif) {
			if (gr.getCode().equals(newcotisation.getCode())) {
				bool = true;
			}

		}
		assertTrue(bool);

	}

}