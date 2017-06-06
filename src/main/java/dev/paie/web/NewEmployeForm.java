package dev.paie.web;

public class NewEmployeForm {

	private String matricule;
	private String entreprise;
	private Integer profilRemuneration;
	private Integer grade;

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public Integer getProfilRemuneration() {
		return profilRemuneration;
	}

	public void setProfilRemuneration(Integer profil) {
		this.profilRemuneration = profil;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

}
