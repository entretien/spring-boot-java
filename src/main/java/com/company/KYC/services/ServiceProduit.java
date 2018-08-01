package com.company.KYC.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.company.KYC.exceptions.ResourceNotFoundException;
import com.company.KYC.models.PRODUIT;
import com.company.KYC.repositories.PRODUIT_repository;
import com.company.KYC.repositories.PRODUIT_specification;
import com.company.KYC.repositories.SearchCriteria;

public class ServiceProduit {
	
	private PRODUIT_repository repoProduit;
	
	private String filter_categorie;
	private String filter_libelle;
	private String filter_sourceExterne;
	private String filter_sourceInterne;	
	private String filter_note;
	private String tri;
	
	
	
	
	
	public List<PRODUIT> CreerProduits( List<PRODUIT> produits ) {
		return repoProduit.saveAll(produits);
	}

	public PRODUIT ModifierProduit( PRODUIT produit ) {
		Optional<PRODUIT> produitOpt = repoProduit.findById(produit.getLibelle());
		if( ! produitOpt.isPresent() ) {
			String errMsg = "Le pays " + produit.getLibelle() + " n'a pas été trouvé";
			throw new ResourceNotFoundException(produit.getLibelle(), errMsg);
		}
		return repoProduit.save(produit);
	}
	
	public List<PRODUIT> ObtenirListeProduits() {
		List<PRODUIT> produits = new ArrayList<PRODUIT>();
		Specification<PRODUIT> spec = this.AssembleSpecification();
		Sort sort = this.AssembleSort();
		produits = repoProduit.findAll(spec,sort);
		return produits;
	}
	
	public PRODUIT ObtenirProduit(String nom) {
		Optional<PRODUIT> produitOpt = repoProduit.findById(nom);
		if( ! produitOpt.isPresent() ) {
			String errMsg = "Le produit " + nom + " n'a pas été trouvé";
			throw new ResourceNotFoundException(nom, errMsg);
		} else {
			return produitOpt.get();
		}
	}
	
	
	private Specification<PRODUIT> AssembleSpecification() {
		
		Specification<PRODUIT> specTmp = null;
		Specification<PRODUIT> spec= null;
		
		if(filter_categorie!=null) {
			specTmp = new PRODUIT_specification( new SearchCriteria("categorie", "=", filter_categorie) );
			spec = specTmp;
		}
		if(filter_libelle!=null) {
			specTmp = new PRODUIT_specification( new SearchCriteria("libelle", "=", filter_libelle) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		if(filter_sourceExterne!=null) {
			specTmp = new PRODUIT_specification( new SearchCriteria("sourceExterne", ":", filter_sourceExterne) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		if(filter_sourceInterne!=null) {
			specTmp = new PRODUIT_specification( new SearchCriteria("sourceInterne", ":", filter_sourceInterne) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}
		if(filter_note!=null) {
			specTmp = new PRODUIT_specification( new SearchCriteria("note", "=", filter_note) );
			if(spec == null) {
				spec = specTmp;
			} else {
				spec.and( specTmp );	
			}
		}	
		return spec;
	}


	private Sort AssembleSort() {
		List<String> ordre = new ArrayList<String>();
		ordre = Arrays.asList( this.tri.split(",") );
		Sort sort = new Sort(Sort.Direction.ASC, ordre);
		return sort;
	}
	
	
	
	
	
	
	public void setFilters(String filter_categorie, String filter_libelle, String filter_sourceExterne,
			String filter_sourceInterne, String filter_note) {
		this.filter_categorie = filter_categorie;
		this.filter_libelle = filter_libelle;
		this.filter_sourceExterne = filter_sourceExterne;
		this.filter_sourceInterne = filter_sourceInterne;
		this.filter_note = filter_note;
	}
	
	public void resetFilters() {
		this.filter_categorie = null;
		this.filter_libelle = null;
		this.filter_sourceExterne = null;
		this.filter_sourceInterne = null;	
		this.filter_note = null;
	}

	public ServiceProduit(PRODUIT_repository repoProduit) {
		super();
		this.repoProduit = repoProduit;
		this.filter_categorie = null;
		this.filter_libelle = null;
		this.filter_sourceExterne = null;
		this.filter_sourceInterne = null;	
		this.filter_note = null;
		this.tri = "categorie,libelle";
	}

	public PRODUIT_repository getRepoProduit() {
		return repoProduit;
	}

	public void setRepoProduit(PRODUIT_repository repoProduit) {
		this.repoProduit = repoProduit;
	}

	public String getFilter_categorie() {
		return filter_categorie;
	}

	public void setFilter_categorie(String filter_categorie) {
		this.filter_categorie = filter_categorie;
	}

	public String getFilter_libelle() {
		return filter_libelle;
	}

	public void setFilter_libelle(String filter_libelle) {
		this.filter_libelle = filter_libelle;
	}

	public String getFilter_sourceExterne() {
		return filter_sourceExterne;
	}

	public void setFilter_sourceExterne(String filter_sourceExterne) {
		this.filter_sourceExterne = filter_sourceExterne;
	}

	public String getFilter_sourceInterne() {
		return filter_sourceInterne;
	}

	public void setFilter_sourceInterne(String filter_sourceInterne) {
		this.filter_sourceInterne = filter_sourceInterne;
	}

	public String getFilter_note() {
		return filter_note;
	}

	public void setFilter_note(String filter_note) {
		this.filter_note = filter_note;
	}

	public String getTri() {
		return tri;
	}

	public void setTri(String tri) {
		this.tri = tri;
	}
	

}
