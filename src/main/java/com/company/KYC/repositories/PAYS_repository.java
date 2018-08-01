package com.company.KYC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.company.KYC.models.PAYS;

@Repository
public interface PAYS_repository extends JpaRepository<PAYS, String>, JpaSpecificationExecutor<PAYS> {

}
