package com.alanmcgillivray.tournament.service.impl;

import com.alanmcgillivray.tournament.dto.PlayerResponse;
import com.alanmcgillivray.tournament.dto.TeamRequest;
import com.alanmcgillivray.tournament.dto.TeamResponse;
import com.alanmcgillivray.tournament.exception.ResourceNotFoundException;
import com.alanmcgillivray.tournament.mapper.PlayerMapper;
import com.alanmcgillivray.tournament.mapper.TeamMapper;
import com.alanmcgillivray.tournament.model.Player;
import com.alanmcgillivray.tournament.model.Team;
import com.alanmcgillivray.tournament.repository.PlayerRepository;
import com.alanmcgillivray.tournament.repository.TeamRepository;
import com.alanmcgillivray.tournament.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;
    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    public TeamServiceImpl(
            TeamRepository teamRepository,
            TeamMapper teamMapper,
            PlayerRepository playerRepository,
            PlayerMapper playerMapper) {

        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
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

    @Override
    public void addPlayerToTeam(Long teamId, Long playerId) {

        Team team = teamRepository.findById(teamId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Team not found with id: " + teamId));

        Player player = playerRepository.findById(playerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Player not found with id: " + playerId));

        player.setTeam(team);

        playerRepository.save(player);
    }

    @Override
    public List<PlayerResponse> getPlayersForTeam(Long teamId) {

        Team team = teamRepository.findById(teamId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Team not found with id: " + teamId));

        return team.getPlayers()
                .stream()
                .map(playerMapper::toResponse)
                .toList();
    }
}