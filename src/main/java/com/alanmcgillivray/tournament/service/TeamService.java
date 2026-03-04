package com.alanmcgillivray.tournament.service;

import com.alanmcgillivray.tournament.dto.TeamRequest;
import com.alanmcgillivray.tournament.dto.TeamResponse;

import java.util.List;

public interface TeamService {

    TeamResponse createTeam(TeamRequest request);

    List<TeamResponse> getAllTeams();

    TeamResponse getTeamById(Long id);

    void deleteTeam(Long id);
}