package com.company.KYC.repositories;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.company.KYC.models.CLIENT;

@Repository
public interface CLIENT_repository extends JpaRepository<CLIENT, Long>, JpaSpecificationExecutor<CLIENT> {

	
}
