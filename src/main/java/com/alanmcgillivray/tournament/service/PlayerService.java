package com.alanmcgillivray.tournament.service;

import com.alanmcgillivray.tournament.dto.PlayerRequest;
import com.alanmcgillivray.tournament.dto.PlayerResponse;

import java.util.List;

public interface PlayerService {
    PlayerResponse createPlayer(PlayerRequest request);
    PlayerResponse getPlayerById(Long id);
    List<PlayerResponse> getAllPlayers();
    PlayerResponse updatePlayer(Long id, PlayerRequest request);
    void deletePlayer(Long id);

}
