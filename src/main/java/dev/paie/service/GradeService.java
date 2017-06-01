package dev.paie.service;

import java.util.List;

import dev.paie.entite.Grade;

public interface GradeService {
	
	void sauvegarder(Grade saveGrade);
	
	 List<Grade> lister (); 
	
	void mettre_a_jour (Grade updateGrade);

}
