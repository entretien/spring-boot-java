package com.company.KYC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.company.KYC.models.SECTEUR;

@Repository
public interface SECTEUR_repository  extends JpaRepository<SECTEUR,String>, JpaSpecificationExecutor<SECTEUR>  {

}
