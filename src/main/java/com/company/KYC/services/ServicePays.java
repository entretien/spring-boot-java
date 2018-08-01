package com.company.KYC.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.company.KYC.models.PAYS;
import com.company.KYC.repositories.PAYS_repository;
import com.company.KYC.repositories.PAYS_specification;
import com.company.KYC.repositories.SearchCriteria;
import com.company.KYC.exceptions.ResourceNotFoundException;

public class ServicePays {
	
	private PAYS_repository repoPays;
	
	private String filter_nom;
	private String filter_index;
	private String filter_iso;
	private String filter_noteIntStr;
	private String filter_noteStr;
	private String filter_presencePays;
	private String filter_paysSanction;
	private String filter_depositaireReconnu;
	private String filter_implantationRetail1;
	private String filter_implantationRetail2;
	private String filter_membreEuropeen;
	private String tri;
	
	
	
	public List<PAYS> CreerPays( List<PAYS> pays ) {
		return repoPays.saveAll(pays);
	}

	
	public PAYS ModifierPays( PAYS pays ) {
		Optional<PAYS> paysOpt = repoPays.findById(pays.getNom());
		if( ! paysOpt.isPresent() ) {
			String errMsg = "Le pays " + pays.getNom() + " n'a pas été trouvé";
			throw new ResourceNotFoundException(pays.getNom(), errMsg);
		}
		return repoPays.save(pays);
	}
	

	public List<PAYS> ObtenirListePays() {
		List<PAYS> pays = new ArrayList<PAYS>();
		Specification<PAYS> spec = this.AssembleSpecification();
		Sort sort = this.AssembleSort();
		pays = repoPays.findAll(spec,sort);
		return pays;
	}


	public PAYS ObtenirPays(String nom) {
		Optional<PAYS> paysOpt = repoPays.findById(nom);
		if( ! paysOpt.isPresent() ) {
			String errMsg = "Le pays " + nom + " n'a pas été trouvé";
			throw new ResourceNotFoundException(nom, errMsg);
		} else {
			return paysOpt.get();
		}
	}


	private Sort AssembleSort() {
		List<String> ordre = new ArrayList<String>();
		ordre = Arrays.asList( this.tri.split(",") );
		Sort sort = new Sort(Sort.Direction.ASC, ordre);
		return sort;
	}
	
	
	private Specification<PAYS> AssembleSpecification() {
		
		Specification<PAYS> specTmp = null;
		Specification<PAYS> spec= null;
		
		if(filter_nom!=null) {
			specTmp = new PAYS_specification( new SearchCriteria("nom", "=", filter_nom) );
			spec = specTmp;
		}
		
		if(filter_index!=null) {
			specTmp = new PAYS_specification( new SearchCriteria("index", "=", filter_index) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_iso!=null) {
			specTmp = new PAYS_specification( new SearchCriteria("iso", "=", filter_iso) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_noteIntStr!=null) {
			int filter_noteInt = new Integer(filter_noteIntStr);
			specTmp = new PAYS_specification( new SearchCriteria("noteInt", "=", filter_noteInt) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
	
		if(filter_noteStr!=null) {
			specTmp = new PAYS_specification( new SearchCriteria("noteStr", "=", filter_noteStr) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_presencePays!=null) {
			specTmp = new PAYS_specification( new SearchCriteria("presencePays", "=", filter_presencePays) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_paysSanction!=null) {
			specTmp = new PAYS_specification( new SearchCriteria("paysSanction", "=", filter_paysSanction) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_depositaireReconnu!=null) {
			specTmp = new PAYS_specification( new SearchCriteria("depositaireReconnu", "=", filter_depositaireReconnu) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_implantationRetail1!=null) {
			specTmp = new PAYS_specification( new SearchCriteria("implantationRetail1", "=", filter_implantationRetail1) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_implantationRetail2!=null) {
			specTmp = new PAYS_specification( new SearchCriteria("implantationRetail2", "=", filter_implantationRetail2) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		
		if(filter_membreEuropeen!=null) {
			specTmp = new PAYS_specification( new SearchCriteria("membreEuropeen", "=", filter_membreEuropeen) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}		
		
		return spec;

	}
	
	
	
	
	public ServicePays(PAYS_repository repoPays) {
		super();
		this.repoPays = repoPays;
		this.filter_nom = null;
		this.filter_index = null;
		this.filter_iso = null;
		this.filter_noteIntStr = null;
		this.filter_noteStr = null;
		this.filter_presencePays = null;
		this.filter_paysSanction = null;
		this.filter_depositaireReconnu = null;
		this.filter_implantationRetail1 = null;
		this.filter_implantationRetail2 = null;
		this.filter_membreEuropeen = null;
		this.tri = "nom";
	}

	public void setFilters(String filter_nom, String filter_index, String filter_iso, String filter_noteIntStr,
			String filter_noteStr, String filter_presencePays, String filter_paysSanction, String filter_depositaireReconnu,
			String filter_implantationRetail1, String filter_implantationRetail2, String filter_membreEuropeen) {
		this.filter_nom = filter_nom;
		this.filter_index = filter_index;
		this.filter_iso = filter_iso;
		this.filter_noteIntStr = filter_noteIntStr;
		this.filter_noteStr = filter_noteStr;
		this.filter_presencePays = filter_presencePays;
		this.filter_paysSanction = filter_paysSanction;
		this.filter_depositaireReconnu = filter_depositaireReconnu;
		this.filter_implantationRetail1 = filter_implantationRetail1;
		this.filter_implantationRetail2 = filter_implantationRetail2;
		this.filter_membreEuropeen = filter_membreEuropeen;
	}

	public void resetFilters() {
		this.filter_nom = null;
		this.filter_index = null;
		this.filter_iso = null;
		this.filter_noteIntStr = null;
		this.filter_noteStr = null;
		this.filter_presencePays = null;
		this.filter_paysSanction = null;
		this.filter_depositaireReconnu = null;
		this.filter_implantationRetail1 = null;
		this.filter_implantationRetail2 = null;
		this.filter_membreEuropeen = null;
	}

	public PAYS_repository getRepoPays() {
		return repoPays;
	}



	public void setRepoPays(PAYS_repository repoPays) {
		this.repoPays = repoPays;
	}



	public String getFilter_nom() {
		return filter_nom;
	}



	public void setFilter_nom(String filter_nom) {
		this.filter_nom = filter_nom;
	}



	public String getFilter_index() {
		return filter_index;
	}



	public void setFilter_index(String filter_index) {
		this.filter_index = filter_index;
	}



	public String getFilter_iso() {
		return filter_iso;
	}



	public void setFilter_iso(String filter_iso) {
		this.filter_iso = filter_iso;
	}



	public String getFilter_noteIntStr() {
		return filter_noteIntStr;
	}



	public void setFilter_noteInt(String filter_noteIntStr) {
		this.filter_noteIntStr = filter_noteIntStr;
	}



	public String getFilter_noteStr() {
		return filter_noteStr;
	}



	public void setFilter_noteStr(String filter_noteStr) {
		this.filter_noteStr = filter_noteStr;
	}



	public String getFilter_presencePays() {
		return filter_presencePays;
	}



	public void setFilter_presencePays(String filter_presencePays) {
		this.filter_presencePays = filter_presencePays;
	}



	public String getFilter_paysSanction() {
		return filter_paysSanction;
	}



	public void setFilter_paysSanction(String filter_paysSanction) {
		this.filter_paysSanction = filter_paysSanction;
	}



	public String getFilter_depositaireReconnu() {
		return filter_depositaireReconnu;
	}



	public void setFilter_depositaireReconnu(String filter_depositaireReconnu) {
		this.filter_depositaireReconnu = filter_depositaireReconnu;
	}



	public String getFilter_implantationRetail1() {
		return filter_implantationRetail1;
	}



	public void setFilter_implantationRetail1(String filter_implantationRetail1) {
		this.filter_implantationRetail1 = filter_implantationRetail1;
	}



	public String getFilter_implantationRetail2() {
		return filter_implantationRetail2;
	}



	public void setFilter_implantationRetail2(String filter_implantationRetail2) {
		this.filter_implantationRetail2 = filter_implantationRetail2;
	}



	public String getFilter_membreEuropeen() {
		return filter_membreEuropeen;
	}



	public void setFilter_membreEuropeen(String filter_membreEuropeen) {
		this.filter_membreEuropeen = filter_membreEuropeen;
	}



	public String getTri() {
		return tri;
	}


	public void setTri(String tri) {
		this.tri = tri;
	}
	
	public void resetTri() {
		this.tri = "nom";
	}


	@Override
	public String toString() {
		return "ServicePays [repoPays=" + repoPays + ", filter_nom=" + filter_nom + ", filter_index=" + filter_index
				+ ", filter_iso=" + filter_iso + ", filter_noteIntStr=" + filter_noteIntStr + ", filter_noteStr="
				+ filter_noteStr + ", filter_presencePays=" + filter_presencePays + ", filter_paysSanction=" + filter_paysSanction
				+ ", filter_depositaireReconnu=" + filter_depositaireReconnu + ", filter_implantationRetail1="
				+ filter_implantationRetail1 + ", filter_implantationRetail2=" + filter_implantationRetail2
				+ ", filter_membreEuropeen=" + filter_membreEuropeen + "]";
	}
	
	

}
