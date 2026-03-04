package com.alanmcgillivray.tournament.service.impl;

import com.alanmcgillivray.tournament.dto.PlayerRequest;
import com.alanmcgillivray.tournament.dto.PlayerResponse;
import com.alanmcgillivray.tournament.exception.ResourceNotFoundException;
import com.alanmcgillivray.tournament.mapper.PlayerMapper;
import com.alanmcgillivray.tournament.model.Player;
import com.alanmcgillivray.tournament.repository.PlayerRepository;
import com.alanmcgillivray.tournament.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    public PlayerServiceImpl(PlayerRepository playerRepository, PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
    }

    @Override
    public PlayerResponse createPlayer(PlayerRequest request) {

        Player player = playerMapper.toEntity(request);

        Player savedPlayer = playerRepository.save(player);

        return playerMapper.toResponse(savedPlayer);
    }

    @Override
    public PlayerResponse getPlayerById(Long id) {

        Player player = playerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Player not found with id: " + id));

        return playerMapper.toResponse(player);
    }

    @Override
    public List<PlayerResponse> getAllPlayers() {

        return playerRepository.findAll()
                .stream()
                .map(playerMapper::toResponse)
                .toList();
    }

    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public PlayerResponse updatePlayer(Long id, PlayerRequest request) {

        Player player = playerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Player not found with id: " + id));

        player.setName(request.getName());
        player.setLevel(request.getLevel());
        player.setHealth(request.getHealth());
        player.setStrength(request.getStrength());
        player.setDefense(request.getDefense());
        player.setSpeed(request.getSpeed());

        Player updatedPlayer = playerRepository.save(player);

        return playerMapper.toResponse(updatedPlayer);
    }
}
