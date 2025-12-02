package com.example.agency.repositories;

import java.security.Provider.Service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyServiceRepository extends JpaRepository<Service, Long> {
    
}
