package dev.paie.service;

import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	// J'ai une methode calculer de type ResultatCalculRemuneration. 
	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
//je crée un objet de type ResultatCalculRemuneration qui est retourné par ma méthode calculer 
		// pour déja verifier si mon CalculerRemunerationSimpleTest fonction ou pas.
		ResultatCalculRemuneration calculRemuneration = new ResultatCalculRemuneration();
		
		return calculRemuneration;
	}

}
