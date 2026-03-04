package com.alanmcgillivray.tournament.mapper;


import com.alanmcgillivray.tournament.dto.PlayerRequest;
import com.alanmcgillivray.tournament.dto.PlayerResponse;
import com.alanmcgillivray.tournament.model.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {

    public Player toEntity(PlayerRequest request){

        Player player = new Player();

        player.setName(request.getName());
        player.setLevel(request.getLevel());
        player.setHealth(request.getHealth());
        player.setStrength(request.getStrength());
        player.setDefense(request.getDefense());
        player.setSpeed(request.getSpeed());

        return player;
    }

    public PlayerResponse toResponse(Player player){
        return new PlayerResponse(
            player.getId(),
            player.getName(),
            player.getLevel(),
            player.getHealth(),
            player.getStrength(),
            player.getDefense(),
            player.getSpeed()
        );
    }
}
