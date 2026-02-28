package com.alanmcgillivray.tournament.controller;

import com.alanmcgillivray.tournament.model.Player;
import com.alanmcgillivray.tournament.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player){
        return playerService.createPlayer(player);
    }

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable Long id){
        return playerService.getPlayerById(id);
    }

    @GetMapping
    public List<Player> getAllPlayers(){
        return playerService.getAllPlayers();
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id){
        playerService.deletePlayer(id);
    }
}
