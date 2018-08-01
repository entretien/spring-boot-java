package com.company.KYC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.company.KYC.models.PRODUIT;

@Repository
public interface PRODUIT_repository extends JpaRepository<PRODUIT,String>, JpaSpecificationExecutor<PRODUIT> {

}
