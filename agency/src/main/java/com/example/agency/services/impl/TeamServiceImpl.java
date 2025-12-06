package com.example.agency.services.impl;

import com.example.agency.dtos.responce.TeamResponceDTO;
import com.example.agency.models.Team;
import com.example.agency.repositories.TeamRepository;
import com.example.agency.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;


@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private  final TeamRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public TeamResponceDTO getTeamById(Long id) {
        if(repository.existsById(id)) {
            return modelMapper.map(repository.findById(id).orElse(null), TeamResponceDTO.class);
        }
        return null;
    }

    @Override
    public TeamResponceDTO createTeam(TeamResponceDTO dto) {
        if(dto == null) return null;
        Team teamMember = new Team();
        teamMember.setFacebookUrl(dto.getFacebookUrl());
        teamMember.setImageUrl(dto.getImageUrl());
        teamMember.setLinkedinUrl(dto.getLinkedinUrl());
        teamMember.setName(dto.getName());
        teamMember.setRole(dto.getRole());
        teamMember.setTwitterUrl(dto.getTwitterUrl());
        repository.save(teamMember);
        return dto;
    }

    @Override
    public TeamResponceDTO updateTeam(Long id, TeamResponceDTO dto) {
        Team teamMember = repository.findById(id).orElse(null);
        if(dto == null || teamMember == null) return null;
        teamMember.setFacebookUrl(dto.getFacebookUrl());
        teamMember.setImageUrl(dto.getImageUrl());
        teamMember.setLinkedinUrl(dto.getLinkedinUrl());
        teamMember.setName(dto.getName());
        teamMember.setRole(dto.getRole());
        teamMember.setTwitterUrl(dto.getTwitterUrl());
        repository.save(teamMember);
        return dto;
    }

    @Override
    public boolean deleteTeam(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
