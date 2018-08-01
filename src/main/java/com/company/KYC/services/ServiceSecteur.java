package com.company.KYC.services;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.company.KYC.exceptions.ResourceNotFoundException;
import com.company.KYC.models.SECTEUR;
import com.company.KYC.repositories.SECTEUR_repository;
import com.company.KYC.repositories.SECTEUR_specification;
import com.company.KYC.repositories.SearchCriteria;

public class ServiceSecteur {
	
	private SECTEUR_repository repoSecteur;
	
	private String filter_categoriePrincipale;
	private String filter_categorieSecondaire;
	private String filter_libelleFr;
	private String filter_libelleEn;
	private String filter_noteInt;
	private String filter_noteStr;
	private String tri;
	
	
	public List<SECTEUR> CreerSecteur( List<SECTEUR> secteurs ) {
		return repoSecteur.saveAll(secteurs);
	}

	
	public SECTEUR ModifierPays( SECTEUR secteur ) {
		Optional<SECTEUR> secteurOpt = repoSecteur.findById(secteur.getLibelleEn());
		if( ! secteurOpt.isPresent() ) {
			String errMsg = "Le secteur " + secteur.getLibelleEn() + " n'a pas été trouvé";
			throw new ResourceNotFoundException(secteur.getLibelleEn(), errMsg);
		}
		return repoSecteur.save(secteur);
	}
	

	public List<SECTEUR> ObtenirListeSecteur() {
		List<SECTEUR> pays = new ArrayList<SECTEUR>();
		Specification<SECTEUR> spec = this.AssembleSpecification();
		Sort sort = this.AssembleSort();
		pays = repoSecteur.findAll(spec,sort);
		return pays;
	}


	public SECTEUR ObtenirSecteur(String nom) {
		Optional<SECTEUR> sectionOpt = repoSecteur.findById(nom);
		if( ! sectionOpt.isPresent() ) {
			String errMsg = "Le secteur " + nom + " n'a pas été trouvé";
			throw new ResourceNotFoundException(nom, errMsg);
		} else {
			return sectionOpt.get();
		}
	}
	
	
	private Sort AssembleSort() {
		List<String> ordre = new ArrayList<String>();
		ordre = Arrays.asList( this.tri.split(",") );
		Sort sort = new Sort(Sort.Direction.ASC, ordre);
		return sort;
	}
	
	private Specification<SECTEUR> AssembleSpecification() {
		
		Specification<SECTEUR> specTmp = null;
		Specification<SECTEUR> spec= null;
		
		if(filter_categoriePrincipale!=null) {
			specTmp = new SECTEUR_specification( new SearchCriteria("categoriePrincipale", "=", filter_categoriePrincipale) );
			spec = specTmp;
		}
		if(filter_categorieSecondaire!=null) {
			specTmp = new SECTEUR_specification( new SearchCriteria("categorieSecondaire", "=", filter_categorieSecondaire) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		if(filter_libelleFr!=null) {
			specTmp = new SECTEUR_specification( new SearchCriteria("libelleFr", ":", filter_libelleFr) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		if(filter_libelleEn!=null) {
			specTmp = new SECTEUR_specification( new SearchCriteria("libelleEn", ":", filter_libelleEn) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		if(filter_noteInt!=null) {
			specTmp = new SECTEUR_specification( new SearchCriteria("noteInt", "=", filter_noteInt) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		if(filter_noteStr!=null) {
			specTmp = new SECTEUR_specification( new SearchCriteria("noteStr", "=", filter_noteStr) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		return spec;
	}


	public ServiceSecteur(SECTEUR_repository repoSecteur, String codeLangue) {
		super();
		this.repoSecteur = repoSecteur;
		this.tri = "categoriePrincipale,categorieSecondaire";
		if(codeLangue.equals("FR")) {
			this.tri = this.tri + ",libelleFr";
		} else {
			this.tri = this.tri + ",libelleEn";	
		}
	}


	public void setFilters(String filter_categoriePrincipale, String filter_categorieSecondaire, String filter_libelleFr,
			String filter_libelleEn, String filter_noteInt, String filter_noteStr) {
		this.filter_categoriePrincipale = filter_categoriePrincipale;
		this.filter_categorieSecondaire = filter_categorieSecondaire;
		this.filter_libelleFr = filter_libelleFr;
		this.filter_libelleEn = filter_libelleEn;
		this.filter_noteInt = filter_noteInt;
		this.filter_noteStr = filter_noteStr;
	}
	
	
	public void resetFilters() {
		this.filter_categoriePrincipale = null;
		this.filter_categorieSecondaire = null;
		this.filter_libelleFr = null;
		this.filter_libelleEn = null;
		this.filter_noteInt = null;
		this.filter_noteStr = null;
	}


	public SECTEUR_repository getRepoSecteur() {
		return repoSecteur;
	}


	public void setRepoSecteur(SECTEUR_repository repoSecteur) {
		this.repoSecteur = repoSecteur;
	}


	public String getFilter_categoriePrincipale() {
		return filter_categoriePrincipale;
	}


	public void setFilter_categoriePrincipale(String filter_categoriePrincipale) {
		this.filter_categoriePrincipale = filter_categoriePrincipale;
	}


	public String getFilter_categorieSecondaire() {
		return filter_categorieSecondaire;
	}


	public void setFilter_categorieSecondaire(String filter_categorieSecondaire) {
		this.filter_categorieSecondaire = filter_categorieSecondaire;
	}


	public String getFilter_libelleFr() {
		return filter_libelleFr;
	}


	public void setFilter_libelleFr(String filter_libelleFr) {
		this.filter_libelleFr = filter_libelleFr;
	}


	public String getFilter_libelleEn() {
		return filter_libelleEn;
	}


	public void setFilter_libelleEn(String filter_libelleEn) {
		this.filter_libelleEn = filter_libelleEn;
	}


	public String getFilter_noteInt() {
		return filter_noteInt;
	}


	public void setFilter_noteInt(String filter_noteInt) {
		this.filter_noteInt = filter_noteInt;
	}


	public String getFilter_noteStr() {
		return filter_noteStr;
	}


	public void setFilter_noteStr(String filter_noteStr) {
		this.filter_noteStr = filter_noteStr;
	}


	public String getTri() {
		return tri;
	}


	public void setTri(String tri) {
		this.tri = tri;
	}


}
