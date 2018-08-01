package com.company.KYC.controllers;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.KYC.exceptions.ResourceNotFoundException;
import com.company.KYC.models.CLIENT;
import com.company.KYC.models.PAYS;
import com.company.KYC.models.PRODUIT;
import com.company.KYC.models.SECTEUR;
import com.company.KYC.repositories.CLIENT_repository;
import com.company.KYC.repositories.PAYS_repository;
import com.company.KYC.repositories.PRODUIT_repository;
import com.company.KYC.repositories.SECTEUR_repository;
import com.company.KYC.services.ServiceClient;
import com.company.KYC.services.ServicePays;
import com.company.KYC.services.ServiceProduit;
import com.company.KYC.services.ServiceSecteur;



@RestController
public class KYCController {

	@Autowired
	CLIENT_repository repoClient;

	@Autowired
	PAYS_repository repoPays;

	@Autowired
	SECTEUR_repository repoSecteur;

	@Autowired
	PRODUIT_repository repoProduit;


	@CrossOrigin(origins = "*")
	@GetMapping("/clients")
	public List<CLIENT> getallClients() {
		// TODO : ajouter params de filtre.
		ServiceClient serviceClient = new ServiceClient(repoClient);
		return serviceClient.ObtenirListeClient();
	}


	@CrossOrigin(origins = "*")
	@GetMapping("/clients/{identifiant}")
	public CLIENT getClientById( @PathVariable(value = "identifiant") Long identifiant ) {
		Optional<CLIENT> optClient =  repoClient.findById(identifiant);
		if( ! optClient.isPresent() ) {
			String errMsg = "Aucun Approbateur ne correspond aux identifiants spécifiés.";
			throw new ResourceNotFoundException( String.valueOf(identifiant), errMsg);
		}
		return optClient.get();
	}


	@DeleteMapping("/clients")
	public void deleteJuridApprobateur() {
		repoClient.deleteAll();
	}


	@CrossOrigin(origins = "*")
	@PostMapping("/clients")
	@Transactional(rollbackFor=Exception.class)
	public CLIENT createClient(@Valid @RequestBody CLIENT client) {
		return repoClient.save(client);
	}
	
	
	@CrossOrigin(origins = "*")
	@PutMapping("/clients")
	@Transactional(rollbackFor=Exception.class)
	public CLIENT modifyClient(@Valid @RequestBody CLIENT client) {
		Optional <CLIENT> optClient = repoClient.findById(client.getIdentifiant());
		if( ! optClient.isPresent() ) {
			String errMsg = "Aucun Client ne correspond aux identifiants spécifiés.";
			throw new ResourceNotFoundException(client.getIdentifiant().toString(), errMsg);
		}
		return repoClient.save(client);
	}


	@CrossOrigin(origins = "*")
	@DeleteMapping("/clients/{identifiant}")
	@Transactional(rollbackFor=Exception.class)
	public void deleteClientById( @PathVariable(value = "identifiant") Long identifiant) {
		Optional<CLIENT> optAppro =  repoClient.findById(identifiant);
		if( ! optAppro.isPresent() ) {
			String errMsg = "Aucun Approbateur ne correspond aux identifiants spécifiés.";
			throw new ResourceNotFoundException(identifiant.toString(), errMsg);
		} else {
			repoClient.deleteById(identifiant);
		}
	}


	@CrossOrigin(origins = "*")
	@GetMapping("/pays")
	public List<PAYS> getallPays(
			@RequestParam(value = "nom", required = false) String nom,
			@RequestParam(value = "index", required = false) String index,
			@RequestParam(value = "iso", required = false) String iso,
			@RequestParam(value = "noteInt", required = false) String noteInt,
			@RequestParam(value = "noteStr", required = false) String noteStr,
			@RequestParam(value = "presencePays", required = false) String presencePays,
			@RequestParam(value = "paysSanction", required = false) String paysSanction,
			@RequestParam(value = "depositaireReconnu", required = false) String depositaireReconnu,
			@RequestParam(value = "implantationRetail1", required = false) String implantationRetail1,
			@RequestParam(value = "implantationRetail2", required = false) String implantationRetail2,
			@RequestParam(value = "membreEuropeen", required = false) String membreEuropeen,
			@RequestParam(value = "tri", required = false) String tri
			) {
		ServicePays servicePays = new ServicePays(repoPays);
		if( tri != null) {
			servicePays.setTri(tri);
		}
		servicePays.setFilters(nom, index, iso, noteInt, noteStr, presencePays, paysSanction, depositaireReconnu, implantationRetail1, implantationRetail2, membreEuropeen);
		return servicePays.ObtenirListePays();
	}


	@CrossOrigin(origins = "*")
	@GetMapping("/secteurs")
	public List<SECTEUR> getallSecteurs(
			@RequestParam(value = "categoriePrincipale", required = false) String categoriePrincipale,
			@RequestParam(value = "categorieSecondaire", required = false) String categorieSecondaire,
			@RequestParam(value = "libelleFr", required = false) String libelleFr,
			@RequestParam(value = "libelleEn", required = false) String libelleEn,
			@RequestParam(value = "noteInt", required = false) String noteInt,
			@RequestParam(value = "noteStr", required = false) String noteStr,
			@RequestParam(value = "tri", required = false) String tri ) {
		ServiceSecteur serviceSecteur = new ServiceSecteur(repoSecteur,"EN");
		if( tri != null) {
			serviceSecteur.setTri(tri);
		}
		serviceSecteur.setFilters(categoriePrincipale, categorieSecondaire, libelleFr, libelleEn, noteInt, noteStr);
		return serviceSecteur.ObtenirListeSecteur();
	}


	@CrossOrigin(origins = "*")
	@GetMapping("/produits")
	public List<PRODUIT> getallProduits(
			@RequestParam(value = "categorie", required = false) String categorie,
			@RequestParam(value = "libelle", required = false) String libelle,
			@RequestParam(value = "sourceExterne", required = false) String sourceExterne,
			@RequestParam(value = "sourceInterne", required = false) String sourceInterne,	
			@RequestParam(value = "note", required = false) String note,
			@RequestParam(value = "tri", required = false) String tri ) {
		ServiceProduit serviceProduit = new ServiceProduit(repoProduit);
		if( tri != null) {
			serviceProduit.setTri(tri);
		}
		serviceProduit.setFilters(categorie, libelle, sourceExterne, sourceInterne, note);
		return serviceProduit.ObtenirListeProduits();
	}

	
}
