package com.alanmcgillivray.tournament.controller;

import com.alanmcgillivray.tournament.dto.PlayerRequest;
import com.alanmcgillivray.tournament.dto.PlayerResponse;
import com.alanmcgillivray.tournament.model.Player;
import com.alanmcgillivray.tournament.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
@ResponseStatus(HttpStatus.CREATED)
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService){this.playerService = playerService;}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerResponse createPlayer(@Valid @RequestBody PlayerRequest request) {
        return playerService.createPlayer(request);
    }

    @GetMapping("/{id}")
    public PlayerResponse getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }

    @GetMapping
    public List<PlayerResponse> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PutMapping("/{id}")
    public PlayerResponse updatePlayer(
            @PathVariable Long id,
            @Valid @RequestBody PlayerRequest request) {

        return playerService.updatePlayer(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id){
        playerService.deletePlayer(id);
    }
}
