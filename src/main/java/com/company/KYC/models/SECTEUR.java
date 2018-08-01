package com.company.KYC.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SECTEUR")
public class SECTEUR {
	
	@Column(name="CATEGORIE_PRINCIPALE")
	private String categoriePrincipale;
	
	@Column(name="CATEGORIE_SECONDAIRE")
	private String categorieSecondaire;
	
	@Id
	@Column(name="LIBELLE_EN")
	private String libelleEn;
	
	@Column(name="LIBELLE_FR")
	private String libelleFr;
	
	@Column(name="NOTE_INT")
	private String noteInt;
	
	@Column(name="NOTE_STR")
	private String noteStr;

	public SECTEUR() {
		super();
	}

	public SECTEUR(String categoriePrincipale, String categorieSecondaire, String libelleFr, String libelleEn,
			String noteInt, String noteStr) {
		super();
		this.categoriePrincipale = categoriePrincipale;
		this.categorieSecondaire = categorieSecondaire;
		this.libelleFr = libelleFr;
		this.libelleEn = libelleEn;
		this.noteInt = noteInt;
		this.noteStr = noteStr;
	}

	public String getCategoriePrincipale() {
		return categoriePrincipale;
	}

	public void setCategoriePrincipale(String categoriePrincipale) {
		this.categoriePrincipale = categoriePrincipale;
	}

	public String getCategorieSecondaire() {
		return categorieSecondaire;
	}

	public void setCategorieSecondaire(String categorieSecondaire) {
		this.categorieSecondaire = categorieSecondaire;
	}

	public String getLibelleFr() {
		return libelleFr;
	}

	public void setLibelleFr(String libelleFr) {
		this.libelleFr = libelleFr;
	}

	public String getLibelleEn() {
		return libelleEn;
	}

	public void setLibelleEn(String libelleEn) {
		this.libelleEn = libelleEn;
	}

	public String getNoteInt() {
		return noteInt;
	}

	public void setNoteInt(String noteInt) {
		this.noteInt = noteInt;
	}

	public String getNoteStr() {
		return noteStr;
	}

	public void setNoteStr(String noteStr) {
		this.noteStr = noteStr;
	}

	@Override
	public String toString() {
		return "SECTEUR [categoriePrincipale=" + categoriePrincipale + ", categorieSecondaire=" + categorieSecondaire
				+ ", libelleFr=" + libelleFr + ", libelleEn=" + libelleEn + ", noteInt=" + noteInt + ", noteStr="
				+ noteStr + "]";
	}

}
