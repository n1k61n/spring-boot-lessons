package com.example.agency.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agency.models.TeamMember;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
    
}
