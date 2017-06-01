package dev.paie.service;

import dev.paie.entite.Grade;

public interface GradeService {
	
	void sauvegarder(Grade saveGrade);
	
	void lister (Grade listGrade);
	
	void mettre_a_jour (Grade updateGrade);

}
