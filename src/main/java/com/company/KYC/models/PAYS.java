package com.company.KYC.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAYS")
public class PAYS {
	
	@Id
	@Column(name="NOM")
	private String nom;
	
	@Column(name="INDEX")
	private String index;
	
	@Column(name="ISO")
	private String iso;
	
	@Column(name="NOTE_INT")
	private int noteInt;
	
	@Column(name="NOTE_STR")
	private String noteStr;
	
	@Column(name="PRESENCE_PAYS")
	private String presencePays;
	
	@Column(name="PAYS_SANCTION")
	private String paysSanction;
	
	@Column(name="DEPOSITAIRE_RECONNU")
	private String depositaireReconnu;
	
	@Column(name="IMPLANTATION_RETAIL_1")
	private String implantationRetail1;
	
	@Column(name="IMPLANTATION_RETAIL_2")
	private String implantationRetail2;
	
	@Column(name="MEMBRE_EUROPEEN")
	private String membreEuropeen;

	
	public PAYS() {
		super();
	}


	public PAYS(String nom, String index, String iso, int noteInt, String noteStr, String presencePays, String paysSanction,
			String depositaireReconnu, String implantationRetail1, String implantationRetail2, String membreEuropeen) {
		super();
		this.nom = nom;
		this.index = index;
		this.iso = iso;
		this.noteInt = noteInt;
		this.noteStr = noteStr;
		this.presencePays = presencePays;
		this.paysSanction = paysSanction;
		this.depositaireReconnu = depositaireReconnu;
		this.implantationRetail1 = implantationRetail1;
		this.implantationRetail2 = implantationRetail2;
		this.membreEuropeen = membreEuropeen;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getIndex() {
		return index;
	}


	public void setIndex(String index) {
		this.index = index;
	}


	public String getIso() {
		return iso;
	}


	public void setIso(String iso) {
		this.iso = iso;
	}


	public int getNoteInt() {
		return noteInt;
	}


	public void setNoteInt(int noteInt) {
		this.noteInt = noteInt;
	}


	public String getNoteStr() {
		return noteStr;
	}


	public void setNoteStr(String noteStr) {
		this.noteStr = noteStr;
	}


	public String getPresencePays() {
		return presencePays;
	}


	public void setPresencePays(String presencePays) {
		this.presencePays = presencePays;
	}


	public String getpaysSanction() {
		return paysSanction;
	}


	public void setpaysSanction(String paysSanction) {
		this.paysSanction = paysSanction;
	}


	public String getdepositaireReconnu() {
		return depositaireReconnu;
	}


	public void setdepositaireReconnu(String depositaireReconnu) {
		this.depositaireReconnu = depositaireReconnu;
	}


	public String getImplantationRetail1() {
		return implantationRetail1;
	}


	public void setImplantationRetail1(String implantationRetail1) {
		this.implantationRetail1 = implantationRetail1;
	}


	public String getImplantationRetail2() {
		return implantationRetail2;
	}


	public void setImplantationRetail2(String implantationRetail2) {
		this.implantationRetail2 = implantationRetail2;
	}


	public String getMembreEuropeen() {
		return membreEuropeen;
	}


	public void setMembreEuropeen(String membreEuropeen) {
		this.membreEuropeen = membreEuropeen;
	}


	@Override
	public String toString() {
		return "PAYS [nom=" + nom + ", index=" + index + ", iso=" + iso + ", noteInt=" + noteInt + ", noteStr="
				+ noteStr + ", presencePays=" + presencePays + ", paysSanction=" + paysSanction + ", depositaireReconnu=" + depositaireReconnu
				+ ", implantationRetail1=" + implantationRetail1 + ", implantationRetail2=" + implantationRetail2
				+ ", membreEuropeen=" + membreEuropeen + "]";
	}
	
}
