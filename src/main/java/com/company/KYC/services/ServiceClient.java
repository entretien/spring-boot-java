package com.company.KYC.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.company.KYC.models.CLIENT;
import com.company.KYC.repositories.CLIENT_repository;
import com.company.KYC.repositories.CLIENT_specification;
import com.company.KYC.repositories.SearchCriteria;

public class ServiceClient {
	
	private CLIENT_repository repoClient;
	
	private Timestamp filter_identifiant;
	private String filter_identifiantAdresse;
	private String filter_nomSocial;
	private String filter_nomCommerce;
	private String filter_formeJuridique;
	private String filter_dateConsitution;
	private String filter_paysImmatriculation;
	private String filter_numeroSiren;
	private String filter_numeroTva;
	private String filter_numeroInternational;
	private String filter_numeroRmpm;
	private String filter_bourseCote;
	private String filter_bourseTypeCote;
	private String filter_bourseNom;
	private String filter_boursePaysIso;
	private String filter_boursePays;
	private String filter_codeCompanyClientCommun;
	private String filter_codeCompanyPresencePays;
	private String filter_codeCompanyRelationHorsPays;
	private String filter_codeCompanyPresenceRetail;
	private String filter_codeNaf;
	private String filter_libelleNafNiveau1;
	private String filter_libelleNafNiveau2;
	private String filter_nomIntermediaire;
	private String filter_roleIntermediaire;
	private String filter_niveauRisqueIntermediaire;
	private String filter_codePresencePaysSanction;
	private String filter_codePresenceNomSanction;
	private String filter_codePresencePep;
	private String filter_segmentCompanypf;
	private String filter_segmentFiliereOrganisation;
	private String filter_segmentNiveau1;
	private String filter_segmentNiveau2;
	private String filter_utilisateurModification;
	private String tri;
	

	
	
	
	
	public List<CLIENT> ObtenirListeClient() {
		List<CLIENT> clients = new ArrayList<CLIENT>();
		Specification<CLIENT> spec = this.assembleSpecification();
		Sort sort = this.assembleSort();
		clients = repoClient.findAll(spec,sort);
		return clients;
	}
	
	
	
	private Sort assembleSort() {
		List<String> ordre = new ArrayList<String>();
		ordre = Arrays.asList( this.tri.split(",") );
		Sort sort = new Sort(Sort.Direction.ASC, ordre);
		return sort;
	}
	
	
	private Specification<CLIENT> assembleSpecification() {
		
		Specification<CLIENT> specTmp = null;
		Specification<CLIENT> spec= null;
		
		if(filter_identifiant!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("identifiant", "=", filter_identifiant) );
			spec = specTmp;
		}
		
		if(filter_identifiantAdresse!=null) {
			int identifiantAdresse = new Integer(filter_identifiantAdresse);
			specTmp = new CLIENT_specification( new SearchCriteria("identifiantAdresse", "=", identifiantAdresse) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}		
		
		if(filter_nomSocial!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("nomSocial", ":", filter_nomSocial) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_nomCommerce!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("nomCommerce", ":", filter_nomCommerce) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}	

		if(filter_formeJuridique!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("formeJuridique", ":", filter_formeJuridique) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_dateConsitution!=null) {
			Date dateConsitution = new Date(filter_dateConsitution);
			specTmp = new CLIENT_specification( new SearchCriteria("dateConsitution", ":", dateConsitution) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_paysImmatriculation!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("paysImmatriculation", ":", filter_paysImmatriculation) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}

		if(filter_numeroSiren!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("numeroSiren", ":", filter_numeroSiren) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_numeroTva!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("numeroTva", ":", filter_numeroTva) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_numeroInternational!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("numeroInternational", ":", filter_numeroInternational) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_numeroRmpm!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("numeroRmpm", ":", filter_numeroRmpm) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_bourseCote!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("bourseCote", ":", filter_bourseCote) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_bourseTypeCote!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("bourseTypeCote", ":", filter_bourseTypeCote) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_bourseNom!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("bourseNom", ":", filter_bourseNom) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}

		if(filter_boursePaysIso!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("boursePaysIso", ":", filter_boursePaysIso) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}

		if(filter_boursePays!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("boursePays", ":", filter_boursePays) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_codeCompanyClientCommun!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("codeCompanyClientCommun", ":", filter_codeCompanyClientCommun) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_codeCompanyPresencePays!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("codeCompanyPresencePays", ":", filter_codeCompanyPresencePays) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_codeCompanyRelationHorsPays!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("codeCompanyRelationHorsPays", ":", filter_codeCompanyRelationHorsPays) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_codeCompanyPresenceRetail!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("codeCompanyPresenceRetail", ":", filter_codeCompanyPresenceRetail) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}		
		
		if(filter_codeNaf!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("codeNaf", ":", filter_codeNaf) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}	
		
		if(filter_libelleNafNiveau1!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("libelleNafNiveau1", ":", filter_libelleNafNiveau1) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_libelleNafNiveau2!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("libelleNafNiveau2", ":", filter_libelleNafNiveau2) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_nomIntermediaire!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("nomIntermediaire", ":", filter_nomIntermediaire) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}		

		if(filter_roleIntermediaire!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("roleIntermediaire", ":", filter_roleIntermediaire) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_niveauRisqueIntermediaire!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("niveauRisqueIntermediaire", ":", filter_niveauRisqueIntermediaire) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_codePresencePaysSanction!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("codePresencePaysSanction", ":", filter_codePresencePaysSanction) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_codePresenceNomSanction!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("codePresenceNomSanction", ":", filter_codePresenceNomSanction) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_codePresencePep!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("codePresencePep", ":", filter_codePresencePep) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_segmentCompanypf!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("segmentCompanypf", ":", filter_segmentCompanypf) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_segmentFiliereOrganisation!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("segmentFiliereOrganisation", ":", filter_segmentFiliereOrganisation) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_segmentNiveau1!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("segmentNiveau1", ":", filter_segmentNiveau1) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_segmentNiveau2!=null) {
			specTmp = new CLIENT_specification( new SearchCriteria("segmentNiveau2", ":", filter_segmentNiveau2) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}

		return spec;
	}
	
	
	
	

	
	
	

	
	
	public ServiceClient(CLIENT_repository repoClient) {
		super();
		this.repoClient = repoClient;
		this.filter_identifiant = null;
		this.filter_identifiantAdresse = null;
		this.filter_nomSocial = null;
		this.filter_nomCommerce = null;
		this.filter_formeJuridique = null;
		this.filter_dateConsitution = null;
		this.filter_paysImmatriculation = null;
		this.filter_numeroSiren = null;
		this.filter_numeroTva = null;
		this.filter_numeroInternational = null;
		this.filter_numeroRmpm = null;
		this.filter_bourseCote = null;
		this.filter_bourseTypeCote = null;
		this.filter_bourseNom = null;
		this.filter_boursePaysIso = null;
		this.filter_boursePays = null;
		this.filter_codeCompanyClientCommun = null;
		this.filter_codeCompanyPresencePays = null;
		this.filter_codeCompanyRelationHorsPays = null;
		this.filter_codeCompanyPresenceRetail = null;
		this.filter_codeNaf = null;
		this.filter_libelleNafNiveau1 = null;
		this.filter_libelleNafNiveau2 = null;
		this.filter_nomIntermediaire = null;
		this.filter_roleIntermediaire = null;
		this.filter_niveauRisqueIntermediaire = null;
		this.filter_codePresencePaysSanction = null;
		this.filter_codePresenceNomSanction = null;
		this.filter_codePresencePep = null;
		this.filter_segmentCompanypf = null;
		this.filter_segmentFiliereOrganisation = null;
		this.filter_segmentNiveau1 = null;
		this.filter_segmentNiveau2 = null;
		this.filter_utilisateurModification = null;
		this.tri = "nomSocial";
	}

	public void setFilters(Timestamp filter_identifiant, String filter_identifiantAdresse, String filter_nomSocial,
			String filter_nomCommerce, String filter_formeJuridique, String filter_dateConsitution,
			String filter_paysImmatriculation, String filter_numeroSiren, String filter_numeroTva,
			String filter_numeroInternational, String filter_numeroRmpm, String filter_bourseCote,
			String filter_bourseTypeCote, String filter_bourseNom, String filter_boursePaysIso,
			String filter_boursePays, String filter_codeCompanyClientCommun, String filter_codeCompanyPresencePays,
			String filter_codeCompanyRelationHorsPays, String filter_codeCompanyPresenceRetail, String filter_codeNaf,
			String filter_libelleNafNiveau1, String filter_libelleNafNiveau2, String filter_nomIntermediaire,
			String filter_roleIntermediaire, String filter_niveauRisqueIntermediaire,
			String filter_codePresencePaysSanction, String filter_codePresenceNomSanction,
			String filter_codePresencePep, String filter_segmentCompanypf, String filter_segmentFiliereOrganisation,
			String filter_segmentNiveau1, String filter_segmentNiveau2, String filter_utilisateurModification) {
		this.filter_identifiant = filter_identifiant;
		this.filter_identifiantAdresse = filter_identifiantAdresse;
		this.filter_nomSocial = filter_nomSocial;
		this.filter_nomCommerce = filter_nomCommerce;
		this.filter_formeJuridique = filter_formeJuridique;
		this.filter_dateConsitution = filter_dateConsitution;
		this.filter_paysImmatriculation = filter_paysImmatriculation;
		this.filter_numeroSiren = filter_numeroSiren;
		this.filter_numeroTva = filter_numeroTva;
		this.filter_numeroInternational = filter_numeroInternational;
		this.filter_numeroRmpm = filter_numeroRmpm;
		this.filter_bourseCote = filter_bourseCote;
		this.filter_bourseTypeCote = filter_bourseTypeCote;
		this.filter_bourseNom = filter_bourseNom;
		this.filter_boursePaysIso = filter_boursePaysIso;
		this.filter_boursePays = filter_boursePays;
		this.filter_codeCompanyClientCommun = filter_codeCompanyClientCommun;
		this.filter_codeCompanyPresencePays = filter_codeCompanyPresencePays;
		this.filter_codeCompanyRelationHorsPays = filter_codeCompanyRelationHorsPays;
		this.filter_codeCompanyPresenceRetail = filter_codeCompanyPresenceRetail;
		this.filter_codeNaf = filter_codeNaf;
		this.filter_libelleNafNiveau1 = filter_libelleNafNiveau1;
		this.filter_libelleNafNiveau2 = filter_libelleNafNiveau2;
		this.filter_nomIntermediaire = filter_nomIntermediaire;
		this.filter_roleIntermediaire = filter_roleIntermediaire;
		this.filter_niveauRisqueIntermediaire = filter_niveauRisqueIntermediaire;
		this.filter_codePresencePaysSanction = filter_codePresencePaysSanction;
		this.filter_codePresenceNomSanction = filter_codePresenceNomSanction;
		this.filter_codePresencePep = filter_codePresencePep;
		this.filter_segmentCompanypf = filter_segmentCompanypf;
		this.filter_segmentFiliereOrganisation = filter_segmentFiliereOrganisation;
		this.filter_segmentNiveau1 = filter_segmentNiveau1;
		this.filter_segmentNiveau2 = filter_segmentNiveau2;
		this.filter_utilisateurModification = filter_utilisateurModification;
	}

	public void resetFilters() {
		this.filter_identifiant = null;
		this.filter_identifiantAdresse = null;
		this.filter_nomSocial = null;
		this.filter_nomCommerce = null;
		this.filter_formeJuridique = null;
		this.filter_dateConsitution = null;
		this.filter_paysImmatriculation = null;
		this.filter_numeroSiren = null;
		this.filter_numeroTva = null;
		this.filter_numeroInternational = null;
		this.filter_numeroRmpm = null;
		this.filter_bourseCote = null;
		this.filter_bourseTypeCote = null;
		this.filter_bourseNom = null;
		this.filter_boursePaysIso = null;
		this.filter_boursePays = null;
		this.filter_codeCompanyClientCommun = null;
		this.filter_codeCompanyPresencePays = null;
		this.filter_codeCompanyRelationHorsPays = null;
		this.filter_codeCompanyPresenceRetail = null;
		this.filter_codeNaf = null;
		this.filter_libelleNafNiveau1 = null;
		this.filter_libelleNafNiveau2 = null;
		this.filter_nomIntermediaire = null;
		this.filter_roleIntermediaire = null;
		this.filter_niveauRisqueIntermediaire = null;
		this.filter_codePresencePaysSanction = null;
		this.filter_codePresenceNomSanction = null;
		this.filter_codePresencePep = null;
		this.filter_segmentCompanypf = null;
		this.filter_segmentFiliereOrganisation = null;
		this.filter_segmentNiveau1 = null;
		this.filter_segmentNiveau2 = null;
		this.filter_utilisateurModification = null;
	}

	public CLIENT_repository getRepoClient() {
		return repoClient;
	}

	public void setRepoClient(CLIENT_repository repoClient) {
		this.repoClient = repoClient;
	}

	public Timestamp getFilter_identifiant() {
		return filter_identifiant;
	}

	public void setFilter_identifiant(Timestamp filter_identifiant) {
		this.filter_identifiant = filter_identifiant;
	}

	public String getFilter_identifiantAdresse() {
		return filter_identifiantAdresse;
	}

	public void setFilter_identifiantAdresse(String filter_identifiantAdresse) {
		this.filter_identifiantAdresse = filter_identifiantAdresse;
	}

	public String getFilter_nomSocial() {
		return filter_nomSocial;
	}

	public void setFilter_nomSocial(String filter_nomSocial) {
		this.filter_nomSocial = filter_nomSocial;
	}

	public String getFilter_nomCommerce() {
		return filter_nomCommerce;
	}

	public void setFilter_nomCommerce(String filter_nomCommerce) {
		this.filter_nomCommerce = filter_nomCommerce;
	}

	public String getFilter_formeJuridique() {
		return filter_formeJuridique;
	}

	public void setFilter_formeJuridique(String filter_formeJuridique) {
		this.filter_formeJuridique = filter_formeJuridique;
	}

	public String getFilter_dateConsitution() {
		return filter_dateConsitution;
	}

	public void setFilter_dateConsitution(String filter_dateConsitution) {
		this.filter_dateConsitution = filter_dateConsitution;
	}

	public String getFilter_paysImmatriculation() {
		return filter_paysImmatriculation;
	}

	public void setFilter_paysImmatriculation(String filter_paysImmatriculation) {
		this.filter_paysImmatriculation = filter_paysImmatriculation;
	}

	public String getFilter_numeroSiren() {
		return filter_numeroSiren;
	}

	public void setFilter_numeroSiren(String filter_numeroSiren) {
		this.filter_numeroSiren = filter_numeroSiren;
	}

	public String getFilter_numeroTva() {
		return filter_numeroTva;
	}

	public void setFilter_numeroTva(String filter_numeroTva) {
		this.filter_numeroTva = filter_numeroTva;
	}

	public String getFilter_numeroInternational() {
		return filter_numeroInternational;
	}

	public void setFilter_numeroInternational(String filter_numeroInternational) {
		this.filter_numeroInternational = filter_numeroInternational;
	}

	public String getFilter_numeroRmpm() {
		return filter_numeroRmpm;
	}

	public void setFilter_numeroRmpm(String filter_numeroRmpm) {
		this.filter_numeroRmpm = filter_numeroRmpm;
	}

	public String getFilter_bourseCote() {
		return filter_bourseCote;
	}

	public void setFilter_bourseCote(String filter_bourseCote) {
		this.filter_bourseCote = filter_bourseCote;
	}

	public String getFilter_bourseTypeCote() {
		return filter_bourseTypeCote;
	}

	public void setFilter_bourseTypeCote(String filter_bourseTypeCote) {
		this.filter_bourseTypeCote = filter_bourseTypeCote;
	}

	public String getFilter_bourseNom() {
		return filter_bourseNom;
	}

	public void setFilter_bourseNom(String filter_bourseNom) {
		this.filter_bourseNom = filter_bourseNom;
	}

	public String getFilter_boursePaysIso() {
		return filter_boursePaysIso;
	}

	public void setFilter_boursePaysIso(String filter_boursePaysIso) {
		this.filter_boursePaysIso = filter_boursePaysIso;
	}

	public String getFilter_boursePays() {
		return filter_boursePays;
	}

	public void setFilter_boursePays(String filter_boursePays) {
		this.filter_boursePays = filter_boursePays;
	}

	public String getFilter_codeCompanyClientCommun() {
		return filter_codeCompanyClientCommun;
	}

	public void setFilter_codeCompanyClientCommun(String filter_codeCompanyClientCommun) {
		this.filter_codeCompanyClientCommun = filter_codeCompanyClientCommun;
	}

	public String getFilter_codeCompanyPresencePays() {
		return filter_codeCompanyPresencePays;
	}

	public void setFilter_codeCompanyPresencePays(String filter_codeCompanyPresencePays) {
		this.filter_codeCompanyPresencePays = filter_codeCompanyPresencePays;
	}

	public String getFilter_codeCompanyRelationHorsPays() {
		return filter_codeCompanyRelationHorsPays;
	}

	public void setFilter_codeCompanyRelationHorsPays(String filter_codeCompanyRelationHorsPays) {
		this.filter_codeCompanyRelationHorsPays = filter_codeCompanyRelationHorsPays;
	}

	public String getFilter_codeCompanyPresenceRetail() {
		return filter_codeCompanyPresenceRetail;
	}

	public void setFilter_codeCompanyPresenceRetail(String filter_codeCompanyPresenceRetail) {
		this.filter_codeCompanyPresenceRetail = filter_codeCompanyPresenceRetail;
	}

	public String getFilter_codeNaf() {
		return filter_codeNaf;
	}

	public void setFilter_codeNaf(String filter_codeNaf) {
		this.filter_codeNaf = filter_codeNaf;
	}

	public String getFilter_libelleNafNiveau1() {
		return filter_libelleNafNiveau1;
	}

	public void setFilter_libelleNafNiveau1(String filter_libelleNafNiveau1) {
		this.filter_libelleNafNiveau1 = filter_libelleNafNiveau1;
	}

	public String getFilter_libelleNafNiveau2() {
		return filter_libelleNafNiveau2;
	}

	public void setFilter_libelleNafNiveau2(String filter_libelleNafNiveau2) {
		this.filter_libelleNafNiveau2 = filter_libelleNafNiveau2;
	}

	public String getFilter_nomIntermediaire() {
		return filter_nomIntermediaire;
	}

	public void setFilter_nomIntermediaire(String filter_nomIntermediaire) {
		this.filter_nomIntermediaire = filter_nomIntermediaire;
	}

	public String getFilter_roleIntermediaire() {
		return filter_roleIntermediaire;
	}

	public void setFilter_roleIntermediaire(String filter_roleIntermediaire) {
		this.filter_roleIntermediaire = filter_roleIntermediaire;
	}

	public String getFilter_niveauRisqueIntermediaire() {
		return filter_niveauRisqueIntermediaire;
	}

	public void setFilter_niveauRisqueIntermediaire(String filter_niveauRisqueIntermediaire) {
		this.filter_niveauRisqueIntermediaire = filter_niveauRisqueIntermediaire;
	}

	public String getFilter_codePresencePaysSanction() {
		return filter_codePresencePaysSanction;
	}

	public void setFilter_codePresencePaysSanction(String filter_codePresencePaysSanction) {
		this.filter_codePresencePaysSanction = filter_codePresencePaysSanction;
	}

	public String getFilter_codePresenceNomSanction() {
		return filter_codePresenceNomSanction;
	}

	public void setFilter_codePresenceNomSanction(String filter_codePresenceNomSanction) {
		this.filter_codePresenceNomSanction = filter_codePresenceNomSanction;
	}

	public String getFilter_codePresencePep() {
		return filter_codePresencePep;
	}

	public void setFilter_codePresencePep(String filter_codePresencePep) {
		this.filter_codePresencePep = filter_codePresencePep;
	}

	public String getFilter_segmentCompanypf() {
		return filter_segmentCompanypf;
	}

	public void setFilter_segmentCompanypf(String filter_segmentCompanypf) {
		this.filter_segmentCompanypf = filter_segmentCompanypf;
	}

	public String getFilter_segmentFiliereOrganisation() {
		return filter_segmentFiliereOrganisation;
	}

	public void setFilter_segmentFiliereOrganisation(String filter_segmentFiliereOrganisation) {
		this.filter_segmentFiliereOrganisation = filter_segmentFiliereOrganisation;
	}

	public String getFilter_segmentNiveau1() {
		return filter_segmentNiveau1;
	}

	public void setFilter_segmentNiveau1(String filter_segmentNiveau1) {
		this.filter_segmentNiveau1 = filter_segmentNiveau1;
	}

	public String getFilter_segmentNiveau2() {
		return filter_segmentNiveau2;
	}

	public void setFilter_segmentNiveau2(String filter_segmentNiveau2) {
		this.filter_segmentNiveau2 = filter_segmentNiveau2;
	}

	public String getFilter_utilisateurModification() {
		return filter_utilisateurModification;
	}

	public void setFilter_utilisateurModification(String filter_utilisateurModification) {
		this.filter_utilisateurModification = filter_utilisateurModification;
	}

	public String getTri() {
		return tri;
	}

	public void setTri(String tri) {
		this.tri = tri;
	}

	public void resetTri() {
		this.tri = "nomSocial";
	}
	
}
