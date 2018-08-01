package com.company.KYC.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUIT")
public class PRODUIT {
	
	@Column(name="CATEGORIE")
	private String categorie;
	
	@Id
	@Column(name="LIBELLE")
	private String libelle;
	
	@Column(name="SOURCE_EXTERNE")
	private String sourceExterne;
	
	@Column(name="SOURCE_INTERNE")
	private String sourceInterne;	

	@Column(name="NOTE")
	private String note;


	public PRODUIT() {
		super();
	}

	public PRODUIT(String categorie, String libelle, String sourceExterne, String sourceInterne, String note) {
		super();
		this.categorie = categorie;
		this.libelle = libelle;
		this.sourceExterne = sourceExterne;
		this.sourceInterne = sourceInterne;
		this.note = note;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getSourceExterne() {
		return sourceExterne;
	}

	public void setSourceExterne(String sourceExterne) {
		this.sourceExterne = sourceExterne;
	}

	public String getSourceInterne() {
		return sourceInterne;
	}

	public void setSourceInterne(String sourceInterne) {
		this.sourceInterne = sourceInterne;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "PRODUIT [categorie=" + categorie + ", libelle=" + libelle + ", sourceExterne=" + sourceExterne
				+ ", sourceInterne=" + sourceInterne + ", note=" + note + "]";
	}

}
