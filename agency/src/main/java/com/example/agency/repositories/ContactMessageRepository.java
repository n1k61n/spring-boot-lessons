package com.example.agency.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agency.models.ContactMessage;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long>   {
    
}
