package com.alanmcgillivray.tournament.service;

import com.alanmcgillivray.tournament.dto.PlayerRequest;
import com.alanmcgillivray.tournament.dto.PlayerResponse;
import com.alanmcgillivray.tournament.mapper.PlayerMapper;
import com.alanmcgillivray.tournament.model.Player;
import com.alanmcgillivray.tournament.repository.PlayerRepository;
import com.alanmcgillivray.tournament.service.impl.PlayerServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlayerServiceTest {

    PlayerRepository playerRepository = Mockito.mock(PlayerRepository.class);
    PlayerMapper playerMapper = new PlayerMapper();

    PlayerServiceImpl playerService =
            new PlayerServiceImpl(playerRepository, playerMapper);

    @Test
    void shouldCreatePlayer() {

        PlayerRequest request = new PlayerRequest();
        request.setName("Knight");
        request.setLevel(1);
        request.setHealth(100);
        request.setStrength(20);
        request.setDefense(15);
        request.setSpeed(10);

        Player savedPlayer = new Player();
        savedPlayer.setId(1L);
        savedPlayer.setName("Knight");
        savedPlayer.setLevel(1);
        savedPlayer.setHealth(100);
        savedPlayer.setStrength(20);
        savedPlayer.setDefense(15);
        savedPlayer.setSpeed(10);

        when(playerRepository.save(any(Player.class))).thenReturn(savedPlayer);

        PlayerResponse response = playerService.createPlayer(request);

        assertNotNull(response);
        assertEquals("Knight", response.getName());
        assertEquals(1L, response.getId());

        verify(playerRepository).save(any(Player.class));
    }

    @Test
    void shouldThrowExceptionWhenPlayerNotFound() {

        when(playerRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> playerService.getPlayerById(1L)
        );

        assertTrue(exception.getMessage().contains("Player not found"));
    }
}