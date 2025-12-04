package com.example.agency.repositories;

import java.security.Provider.Service;

import com.example.agency.models.ServiceAgency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceAgencyRepository extends JpaRepository<ServiceAgency, Long> {
    
}
