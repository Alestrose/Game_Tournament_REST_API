package com.alanmcgillivray.tournament.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlayerResponse {

    private Long id;
    private String name;
    private int level;
    private int health;
    private int strength;
    private int defense;
    private int speed;
}
