package com.alanmcgillivray.tournament.mapper;

import com.alanmcgillivray.tournament.dto.TeamRequest;
import com.alanmcgillivray.tournament.dto.TeamResponse;
import com.alanmcgillivray.tournament.model.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {

    public Team toEntity(TeamRequest request) {

        Team team = new Team();
        team.setName(request.getName());

        return team;
    }

    public TeamResponse toResponse(Team team) {

        return new TeamResponse(
                team.getId(),
                team.getName()
        );
    }
}