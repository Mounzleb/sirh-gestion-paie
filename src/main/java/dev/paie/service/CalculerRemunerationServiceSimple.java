package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	// ici je declare un champs de type PaieUtils pour pouvoir accéder aux
	// methodes de la classe, notamment celle permettant de transformer un
	// BigDecimal en String
	@Autowired
	private PaieUtils paieUtils;

	// J'ai une methode calculer de type ResultatCalculRemuneration.
	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		// je crée un objet de type ResultatCalculRemuneration qui est retourné
		// par ma méthode calculer
		// pour déja verifier si mon CalculerRemunerationSimpleTest fonction ou
		// pas.
		ResultatCalculRemuneration resultat = new ResultatCalculRemuneration();

		// SALAIRE_BASE = GRADE.NB_HEURES_BASE * GRADE.TAUX_BASE
		BigDecimal salaire_base = bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase()
				.multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase());
		// SALAIRE_BRUT = SALAIRE_BASE + PRIME_EXCEPTIONNELLE
		BigDecimal salaire_brut = salaire_base.add(bulletin.getPrimeExceptionnelle());

		// TOTAL_RETENUE_SALARIALE =
		// SOMME(COTISATION_NON_IMPOSABLE.TAUX_SALARIAL*SALAIRE_BRUT)
		List<Cotisation> cotisationsNonImposables = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables();
		List<Cotisation> cotisationsImposables = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsImposables();
		// je convertie ma liste en stream pour pouvoir utiliser les filter, les
		// map etc...
		BigDecimal total_retenue_salarial = cotisationsNonImposables.stream()
				.filter(cotisation -> cotisation.getTauxSalarial() != null)
				.peek(System.out::println)
				.map(cotis -> cotis.getTauxSalarial())
				.map(retenue_salarial -> retenue_salarial.multiply(salaire_brut))
				.peek(System.out::println).collect(Collectors.reducing((v1, v2) -> v1.add(v2))).get();

		BigDecimal total_cotisations_patronales = cotisationsNonImposables.stream()
				.filter(cotisation -> cotisation.getTauxPatronal() != null)
				.map(cotisationPatro -> cotisationPatro.getTauxPatronal())
				.map(cotisation_patronal -> cotisation_patronal.multiply(salaire_brut))
				.collect(Collectors.reducing((v1, v2) -> v1.add(v2))).get();

		// NET_IMPOSABLE = SALAIRE_BRUT - TOTAL_RETENUE_SALARIALE
		BigDecimal net_imposable = salaire_brut.subtract(total_retenue_salarial);

		
		//NET_A_PAYER = NET_IMPOSABLE - SOMME(COTISATION_IMPOSABLE.TAUX_SALARIAL*SALAIRE_BRUT)
		
		BigDecimal cotisation_imposable = cotisationsImposables.stream()
				.filter(cotisation -> cotisation.getTauxSalarial() != null).peek(System.out::println)
				.map(cotis -> cotis.getTauxSalarial()).map(retenue_salarial -> retenue_salarial.multiply(salaire_brut))
				.peek(System.out::println).collect(Collectors.reducing((v1, v2) -> v1.add(v2))).get();

		BigDecimal net_a_payer = net_imposable.subtract(cotisation_imposable);

		// ici je converie mon salaireBrute qui est de type BigDecimal en type
		// String, puis je le stocke dans resultat
		resultat.setSalaireDeBase(paieUtils.formaterBigDecimal(salaire_base));
		resultat.setSalaireBrut(paieUtils.formaterBigDecimal(salaire_brut));
		resultat.setTotalRetenueSalarial(paieUtils.formaterBigDecimal(total_retenue_salarial));
		resultat.setTotalCotisationsPatronales(paieUtils.formaterBigDecimal(total_cotisations_patronales));
		resultat.setNetImposable(paieUtils.formaterBigDecimal(net_imposable));
		resultat.setNetAPayer(paieUtils.formaterBigDecimal(net_a_payer));
		return resultat;
	}

}
