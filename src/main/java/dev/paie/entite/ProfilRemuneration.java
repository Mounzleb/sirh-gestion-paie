package dev.paie.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class ProfilRemuneration {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String code;

	@ManyToMany
	@JoinTable(
			name="profil_cotis_non_imposables",
			joinColumns = 	@JoinColumn(name="id_profil", referencedColumnName="id"),
			inverseJoinColumns = @JoinColumn(name="id_cotis", referencedColumnName="id")
			)
	private List<Cotisation> cotisationsNonImposables;
	
	/*
	 * Dans le ManyToMany on crée une table de jointure entre deux autres
	 * tables. Nos deux tables ici sont profilRemuneration et cotisation
	 */
	@ManyToMany
	@JoinTable(
			name="profil_cotis_imposables",
			joinColumns = 	@JoinColumn(name="id_profil", referencedColumnName="id"),
			inverseJoinColumns = @JoinColumn(name="id_cotis", referencedColumnName="id")
			)
	private List<Cotisation> cotisationsImposables;
	
	
	@ManyToMany
	@JoinTable(
			name="profil_avantage"
			)
	private List<Avantage> avantages;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Cotisation> getCotisationsNonImposables() {
		return cotisationsNonImposables;
	}

	public void setCotisationsNonImposables(List<Cotisation> cotisationsNonImposables) {
		this.cotisationsNonImposables = cotisationsNonImposables;
	}

	public List<Cotisation> getCotisationsImposables() {
		return cotisationsImposables;
	}

	public void setCotisationsImposables(List<Cotisation> cotisationsImposables) {
		this.cotisationsImposables = cotisationsImposables;
	}

	public List<Avantage> getAvantages() {
		return avantages;
	}

	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}

}
