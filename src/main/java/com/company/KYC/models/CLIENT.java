package com.company.KYC.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "T_E_CLIENT_CLI")
public class CLIENT {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CLI_ID")
	private Long identifiant;
	
	@Column(name = "CLI_ADR_ID")
	private int identifiantAdresse;
	
	@Column(name = "CLI_NOM_SOCIAL")
	private String nomSocial;
	
	@Column(name = "CLI_NOM_COMMERCE")
	private String nomCommerce;
	
	@Column(name = "CLI_FORME_JURID")
	private String formeJuridique;
	
	@Column(name = "CLI_DAT_CONSTITUTION")
	private Date dateConsitution;
	
	@Column(name = "CLI_PAYS_IMMATRICULATION")
	private String paysImmatriculation;
	
	@Column(name = "CLI_NUM_SIREN")
	private String numeroSiren;

	@Column(name = "CLI_NUM_TVA")
	private String numeroTva;
	
	@Column(name = "CLI_NUM_INTERNATIONAL")
	private String numeroInternational;
	
	@Column(name = "CLI_NUM_RMPM")
	private String numeroRmpm;
	
	@Column(name = "CLI_BOURSE_COTE")
	private String bourseCote;
	
	@Column(name = "CLI_BOURSE_TYP_COTE")
	private String bourseTypeCote;
	
	@Column(name = "CLI_BOURSE_NOM")
	private String bourseNom;
	
	@Column(name = "CLI_BOURSE_PAYS_ISO")
	private String boursePaysIso;
	
	@Column(name = "CLI_BOURSE_PAY")
	private String boursePays;
	
	@Column(name = "CLI_COMPANY_COD_CLI_COMMUN")
	private String codeCompanyClientCommun;
	
	@Column(name = "CLI_COMPANY_COD_PRESENCE_PAYS")
	private String codeCompanyPresencePays;
	
	@Column(name = "CLI_COMPANY_COD_RELATION_HORS_PAYS")
	private String codeCompanyRelationHorsPays;
	
	@Column(name = "CLI_COMPANY_COD_PRESENCE_RETAIL")
	private String codeCompanyPresenceRetail;
	
	@Column(name = "CLI_COD_NAF")
	private String codeNaf;
	
	@Column(name = "CLI_LIB_NAF_NV1")
	private String libelleNafNiveau1;
	
	@Column(name = "CLI_LIB_NAF_NV2")
	private String libelleNafNiveau2;
	
	@Column(name = "CLI_NOM_INTERMEDIAIRE")
	private String nomIntermediaire;
	
	@Column(name = "CLI_ROLE_INTERMEDIAIRE")
	private String roleIntermediaire;
	
	@Column(name = "CLI_NIV_RIS_INTERMEDIAIRE")
	private String niveauRisqueIntermediaire;
	
	@Column(name = "CLI_COD_PRESENCE_PAYS_SANCTION")
	private String codePresencePaysSanction;
	
	@Column(name = "CLI_COD_PRESENCE_NOM_SANCTION")
	private String codePresenceNomSanction;
	
	@Column(name = "CLI_COD_PRESENCE_PEP")
	private String codePresencePep;
	
	@Column(name = "CLI_SEG_COMPANYPF")
	private String segmentCompanypf;
	
	@Column(name = "CLI_SEG_FILIERE_ORGA")
	private String segmentFiliereOrganisation;
	
	@Column(name = "CLI_SEG_NV1")
	private String segmentNiveau1;
	
	@Column(name = "CLI_SEG_NV2")
	private String segmentNiveau2;
	
	@Column(name = "USER_MODIF")
	private String utilisateurModification;
	
	/*
	@Version
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_MODIF")
	private Date dateModification;
	*/

	public CLIENT() {
		super();
	}

	public CLIENT(Long identifiant, int identifiantAdresse, String nomSocial, String nomCommerce, String formeJuridique,
			Date dateConsitution, String paysImmatriculation, String numeroSiren, String numeroTva,
			String numeroInternational, String numeroRmpm, String bourseCote, String bourseTypeCote, String bourseNom,
			String boursePaysIso, String boursePays, String codeCompanyClientCommun, String codeCompanyPresencePays,
			String codeCompanyRelationHorsPays, String codeCompanyPresenceRetail, String codeNaf, String libelleNafNiveau1,
			String libelleNafNiveau2, String nomIntermediaire, String roleIntermediaire,
			String niveauRisqueIntermediaire, String codePresencePaysSanction, String codePresenceNomSanction,
			String codePresencePep, String segmentCompanypf, String segmentFiliereOrganisation, String segmentNiveau1,
			String segmentNiveau2, String utilisateurModification) {
		super();
		this.identifiant = identifiant;
		this.identifiantAdresse = identifiantAdresse;
		this.nomSocial = nomSocial;
		this.nomCommerce = nomCommerce;
		this.formeJuridique = formeJuridique;
		this.dateConsitution = dateConsitution;
		this.paysImmatriculation = paysImmatriculation;
		this.numeroSiren = numeroSiren;
		this.numeroTva = numeroTva;
		this.numeroInternational = numeroInternational;
		this.numeroRmpm = numeroRmpm;
		this.bourseCote = bourseCote;
		this.bourseTypeCote = bourseTypeCote;
		this.bourseNom = bourseNom;
		this.boursePaysIso = boursePaysIso;
		this.boursePays = boursePays;
		this.codeCompanyClientCommun = codeCompanyClientCommun;
		this.codeCompanyPresencePays = codeCompanyPresencePays;
		this.codeCompanyRelationHorsPays = codeCompanyRelationHorsPays;
		this.codeCompanyPresenceRetail = codeCompanyPresenceRetail;
		this.codeNaf = codeNaf;
		this.libelleNafNiveau1 = libelleNafNiveau1;
		this.libelleNafNiveau2 = libelleNafNiveau2;
		this.nomIntermediaire = nomIntermediaire;
		this.roleIntermediaire = roleIntermediaire;
		this.niveauRisqueIntermediaire = niveauRisqueIntermediaire;
		this.codePresencePaysSanction = codePresencePaysSanction;
		this.codePresenceNomSanction = codePresenceNomSanction;
		this.codePresencePep = codePresencePep;
		this.segmentCompanypf = segmentCompanypf;
		this.segmentFiliereOrganisation = segmentFiliereOrganisation;
		this.segmentNiveau1 = segmentNiveau1;
		this.segmentNiveau2 = segmentNiveau2;
		this.utilisateurModification = utilisateurModification;
	}

	public Long getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(Long identifiant) {
		this.identifiant = identifiant;
	}

	public int getIdentifiantAdresse() {
		return identifiantAdresse;
	}

	public void setIdentifiantAdresse(int identifiantAdresse) {
		this.identifiantAdresse = identifiantAdresse;
	}

	public String getNomSocial() {
		return nomSocial;
	}

	public void setNomSocial(String nomSocial) {
		this.nomSocial = nomSocial;
	}

	public String getNomCommerce() {
		return nomCommerce;
	}

	public void setNomCommerce(String nomCommerce) {
		this.nomCommerce = nomCommerce;
	}

	public String getFormeJuridique() {
		return formeJuridique;
	}

	public void setFormeJuridique(String formeJuridique) {
		this.formeJuridique = formeJuridique;
	}

	public Date getDateConsitution() {
		return dateConsitution;
	}

	public void setDateConsitution(Date dateConsitution) {
		this.dateConsitution = dateConsitution;
	}

	public String getPaysImmatriculation() {
		return paysImmatriculation;
	}

	public void setPaysImmatriculation(String paysImmatriculation) {
		this.paysImmatriculation = paysImmatriculation;
	}

	public String getNumeroSiren() {
		return numeroSiren;
	}

	public void setNumeroSiren(String numeroSiren) {
		this.numeroSiren = numeroSiren;
	}

	public String getNumeroTva() {
		return numeroTva;
	}

	public void setNumeroTva(String numeroTva) {
		this.numeroTva = numeroTva;
	}

	public String getNumeroInternational() {
		return numeroInternational;
	}

	public void setNumeroInternational(String numeroInternational) {
		this.numeroInternational = numeroInternational;
	}

	public String getNumeroRmpm() {
		return numeroRmpm;
	}

	public void setNumeroRmpm(String numeroRmpm) {
		this.numeroRmpm = numeroRmpm;
	}

	public String getBourseCote() {
		return bourseCote;
	}

	public void setBourseCote(String bourseCote) {
		this.bourseCote = bourseCote;
	}

	public String getBourseTypeCote() {
		return bourseTypeCote;
	}

	public void setBourseTypeCote(String bourseTypeCote) {
		this.bourseTypeCote = bourseTypeCote;
	}

	public String getBourseNom() {
		return bourseNom;
	}

	public void setBourseNom(String bourseNom) {
		this.bourseNom = bourseNom;
	}

	public String getBoursePaysIso() {
		return boursePaysIso;
	}

	public void setBoursePaysIso(String boursePaysIso) {
		this.boursePaysIso = boursePaysIso;
	}

	public String getBoursePays() {
		return boursePays;
	}

	public void setBoursePays(String boursePays) {
		this.boursePays = boursePays;
	}

	public String getCodeCompanyClientCommun() {
		return codeCompanyClientCommun;
	}

	public void setCodeCompanyClientCommun(String codeCompanyClientCommun) {
		this.codeCompanyClientCommun = codeCompanyClientCommun;
	}

	public String getCodeCompanyPresencePays() {
		return codeCompanyPresencePays;
	}

	public void setCodeCompanyPresencePays(String codeCompanyPresencePays) {
		this.codeCompanyPresencePays = codeCompanyPresencePays;
	}

	public String getCodeCompanyRelationHorsPays() {
		return codeCompanyRelationHorsPays;
	}

	public void setCodeCompanyRelationHorsPays(String codeCompanyRelationHorsPays) {
		this.codeCompanyRelationHorsPays = codeCompanyRelationHorsPays;
	}

	public String getCodeCompanyPresenceRetail() {
		return codeCompanyPresenceRetail;
	}

	public void setCodeCompanyPresenceRetail(String codeCompanyPresenceRetail) {
		this.codeCompanyPresenceRetail = codeCompanyPresenceRetail;
	}

	public String getCodeNaf() {
		return codeNaf;
	}

	public void setCodeNaf(String codeNaf) {
		this.codeNaf = codeNaf;
	}

	public String getLibelleNafNiveau1() {
		return libelleNafNiveau1;
	}

	public void setLibelleNafNiveau1(String libelleNafNiveau1) {
		this.libelleNafNiveau1 = libelleNafNiveau1;
	}

	public String getLibelleNafNiveau2() {
		return libelleNafNiveau2;
	}

	public void setLibelleNafNiveau2(String libelleNafNiveau2) {
		this.libelleNafNiveau2 = libelleNafNiveau2;
	}

	public String getNomIntermediaire() {
		return nomIntermediaire;
	}

	public void setNomIntermediaire(String nomIntermediaire) {
		this.nomIntermediaire = nomIntermediaire;
	}

	public String getRoleIntermediaire() {
		return roleIntermediaire;
	}

	public void setRoleIntermediaire(String roleIntermediaire) {
		this.roleIntermediaire = roleIntermediaire;
	}

	public String getNiveauRisqueIntermediaire() {
		return niveauRisqueIntermediaire;
	}

	public void setNiveauRisqueIntermediaire(String niveauRisqueIntermediaire) {
		this.niveauRisqueIntermediaire = niveauRisqueIntermediaire;
	}

	public String getCodePresencePaysSanction() {
		return codePresencePaysSanction;
	}

	public void setCodePresencePaysSanction(String codePresencePaysSanction) {
		this.codePresencePaysSanction = codePresencePaysSanction;
	}

	public String getCodePresenceNomSanction() {
		return codePresenceNomSanction;
	}

	public void setCodePresenceNomSanction(String codePresenceNomSanction) {
		this.codePresenceNomSanction = codePresenceNomSanction;
	}

	public String getCodePresencePep() {
		return codePresencePep;
	}

	public void setCodePresencePep(String codePresencePep) {
		this.codePresencePep = codePresencePep;
	}

	public String getSegmentCompanypf() {
		return segmentCompanypf;
	}

	public void setSegmentCompanypf(String segmentCompanypf) {
		this.segmentCompanypf = segmentCompanypf;
	}

	public String getSegmentFiliereOrganisation() {
		return segmentFiliereOrganisation;
	}

	public void setSegmentFiliereOrganisation(String segmentFiliereOrganisation) {
		this.segmentFiliereOrganisation = segmentFiliereOrganisation;
	}

	public String getSegmentNiveau1() {
		return segmentNiveau1;
	}

	public void setSegmentNiveau1(String segmentNiveau1) {
		this.segmentNiveau1 = segmentNiveau1;
	}

	public String getSegmentNiveau2() {
		return segmentNiveau2;
	}

	public void setSegmentNiveau2(String segmentNiveau2) {
		this.segmentNiveau2 = segmentNiveau2;
	}

	public String getUtilisateurModification() {
		return utilisateurModification;
	}

	public void setUtilisateurModification(String utilisateurModification) {
		this.utilisateurModification = utilisateurModification;
	}
/*
	public Date getDateModification() {
		return dateModification;
	}

	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

	@Override
	public String toString() {
		return "CLIENT [identifiant=" + identifiant + ", identifiantAdresse=" + identifiantAdresse + ", nomSocial="
				+ nomSocial + ", nomCommerce=" + nomCommerce + ", formeJuridique=" + formeJuridique
				+ ", dateConsitution=" + dateConsitution + ", paysImmatriculation=" + paysImmatriculation
				+ ", numeroSiren=" + numeroSiren + ", numeroTva=" + numeroTva + ", numeroInternational="
				+ numeroInternational + ", numeroRmpm=" + numeroRmpm + ", bourseCote=" + bourseCote
				+ ", bourseTypeCote=" + bourseTypeCote + ", bourseNom=" + bourseNom + ", boursePaysIso=" + boursePaysIso
				+ ", boursePays=" + boursePays + ", codeCompanyClientCommun=" + codeCompanyClientCommun
				+ ", codeCompanyPresencePays=" + codeCompanyPresencePays + ", codeCompanyRelationHorsPays="
				+ codeCompanyRelationHorsPays + ", codeCompanyPresenceRetail=" + codeCompanyPresenceRetail + ", codeNaf=" + codeNaf
				+ ", libelleNafNiveau1=" + libelleNafNiveau1 + ", libelleNafNiveau2=" + libelleNafNiveau2
				+ ", nomIntermediaire=" + nomIntermediaire + ", roleIntermediaire=" + roleIntermediaire
				+ ", niveauRisqueIntermediaire=" + niveauRisqueIntermediaire + ", codePresencePaysSanction="
				+ codePresencePaysSanction + ", codePresenceNomSanction=" + codePresenceNomSanction
				+ ", codePresencePep=" + codePresencePep + ", segmentCompanypf=" + segmentCompanypf
				+ ", segmentFiliereOrganisation=" + segmentFiliereOrganisation + ", segmentNiveau1=" + segmentNiveau1
				+ ", segmentNiveau2=" + segmentNiveau2 + ", utilisateurModification=" + utilisateurModification
				+ ", dateModification=" + dateModification + "]";
	}
*/
}
