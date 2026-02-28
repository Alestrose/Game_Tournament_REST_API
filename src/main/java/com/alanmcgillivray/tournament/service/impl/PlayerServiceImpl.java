package com.alanmcgillivray.tournament.service.impl;

import com.alanmcgillivray.tournament.exception.ResourceNotFoundException;
import com.alanmcgillivray.tournament.model.Player;
import com.alanmcgillivray.tournament.repository.PlayerRepository;
import com.alanmcgillivray.tournament.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    @Override
    public Player createPlayer(Player player) {

        // Business rule example
        if(player.getHealth() < 0){
            throw new IllegalArgumentException("Health cannot be negative");
        }
        return playerRepository.save(player);
    }

    @Override
    public Player getPlayerById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with id: " + id));
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
