package com.alanmcgillivray.tournament.service.impl;

import com.alanmcgillivray.tournament.dto.TeamRequest;
import com.alanmcgillivray.tournament.dto.TeamResponse;
import com.alanmcgillivray.tournament.exception.ResourceNotFoundException;
import com.alanmcgillivray.tournament.mapper.TeamMapper;
import com.alanmcgillivray.tournament.model.Team;
import com.alanmcgillivray.tournament.repository.TeamRepository;
import com.alanmcgillivray.tournament.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public TeamServiceImpl(TeamRepository teamRepository, TeamMapper teamMapper) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }

    @Override
    public TeamResponse createTeam(TeamRequest request) {

        Team team = teamMapper.toEntity(request);

        Team savedTeam = teamRepository.save(team);

        return teamMapper.toResponse(savedTeam);
    }

    @Override
    public List<TeamResponse> getAllTeams() {

        return teamRepository.findAll()
                .stream()
                .map(teamMapper::toResponse)
                .toList();
    }

    @Override
    public TeamResponse getTeamById(Long id) {

        Team team = teamRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Team not found with id: " + id));

        return teamMapper.toResponse(team);
    }

    @Override
    public void deleteTeam(Long id) {

        if (!teamRepository.existsById(id)) {
            throw new ResourceNotFoundException("Team not found with id: " + id);
        }

        teamRepository.deleteById(id);
    }
}