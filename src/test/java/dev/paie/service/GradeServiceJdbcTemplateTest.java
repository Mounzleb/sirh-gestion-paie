package dev.paie.service;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.JeuxDeDonneesConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;
import dev.paie.spring.DataSourceMySQLConfig;

// ici j'ai choisie mes deux bean dont j'ai besoin et non pas les class ou il y'avait des ComponentScann et donc mon programme avait beaucoup de bean qui ne serve à rien pour ma classe ici présente 
@ContextConfiguration(classes = { GradeServiceJdbcTemplate.class, DataSourceMySQLConfig.class })
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {

	@Autowired
	private GradeService gradeService;

	@Test
	public void test_sauvegarder() {
		Grade saveGrade = new Grade();

		saveGrade.setId(1);
		saveGrade.setCode("code essaie 1");
		saveGrade.setNbHeuresBase(new BigDecimal("200.0"));
		saveGrade.setTauxBase(new BigDecimal("0.8"));

		gradeService.sauvegarder(saveGrade);

	}

	// @Test
	// public void test_lister() {
	//
	// }
	@Test
	public void test_mettre_a_jour() {

		Grade updateGrade = new Grade();

		updateGrade.setId(2);
		updateGrade.setCode(UUID.randomUUID().toString());
		updateGrade.setNbHeuresBase(new BigDecimal("300.0"));
		updateGrade.setTauxBase(new BigDecimal("0.6"));

		gradeService.mettre_a_jour(updateGrade);

	}
}
