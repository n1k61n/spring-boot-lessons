package com.example.agency.repositories;

import java.security.Provider.Service;


import com.example.agency.models.ServiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceItemRepository extends JpaRepository<ServiceItem, Long> {
}
