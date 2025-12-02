package com.example.agency.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agency.models.TimelineEvent;

public interface TimelineEventRepository extends JpaRepository<TimelineEvent, Long> {
    
}
