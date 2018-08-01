package com.company.KYC.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "T_X_ADRESSE_ADR")
public class ADRESSE {
	
	@Id
	@Column(name = "ADR_ID")
	private int identifiant;
	
	@Column(name = "CLI_ID")
	private int identifiantClient;
	
	@Column(name = "ADR_LGN1")
	private String ligne1;
	
	@Column(name = "ADR_LNG2")
	private String ligne2;
	
	@Column(name = "ADR_LNG3")
	private String ligne3;
	
	@Column(name = "ADR_COD_POSTAL")
	private String codePostal;
	
	@Column(name = "ADR_VILLE")
	private String ville;
	
	@Column(name = "ADR_ISO_PAYS")
	private String isoPays;
	
	@Column(name = "ADR_PAYS")
	private String pays;
	
	@Column(name = "ADR_TYP_ADRESSE")
	private String type;
	
	@Column(name = "USER_MODIF")
	private String utilisateurModification;
	
	@Version
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_MODIF")
	private Date dateModification;

	public ADRESSE() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ADRESSE(int identifiant, String ligne1, String ligne2, String ligne3, String codePostal, String ville,
			String isoPays, String pays, String utilisateurModification) {
		super();
		this.identifiant = identifiant;
		this.ligne1 = ligne1;
		this.ligne2 = ligne2;
		this.ligne3 = ligne3;
		this.codePostal = codePostal;
		this.ville = ville;
		this.isoPays = isoPays;
		this.pays = pays;
		this.utilisateurModification = utilisateurModification;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public int getIdentifiantClient() {
		return identifiantClient;
	}

	public void setIdentifiantClient(int identifiantClient) {
		this.identifiantClient = identifiantClient;
	}

	public String getLigne1() {
		return ligne1;
	}

	public void setLigne1(String ligne1) {
		this.ligne1 = ligne1;
	}

	public String getLigne2() {
		return ligne2;
	}

	public void setLigne2(String ligne2) {
		this.ligne2 = ligne2;
	}

	public String getLigne3() {
		return ligne3;
	}

	public void setLigne3(String ligne3) {
		this.ligne3 = ligne3;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getIsoPays() {
		return isoPays;
	}

	public void setIsoPays(String isoPays) {
		this.isoPays = isoPays;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUtilisateurModification() {
		return utilisateurModification;
	}

	public void setUtilisateurModification(String utilisateurModification) {
		this.utilisateurModification = utilisateurModification;
	}

	public Date getDateModification() {
		return dateModification;
	}

	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

	@Override
	public String toString() {
		return "ADRESSE [identifiant=" + identifiant + ", identifiantClient=" + identifiantClient + ", ligne1=" + ligne1
				+ ", ligne2=" + ligne2 + ", ligne3=" + ligne3 + ", codePostal=" + codePostal + ", ville=" + ville
				+ ", isoPays=" + isoPays + ", pays=" + pays + ", type=" + type + ", utilisateurModification="
				+ utilisateurModification + ", dateModification=" + dateModification + "]";
	}

	
}
