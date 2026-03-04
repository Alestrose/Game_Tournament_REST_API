package com.alanmcgillivray.tournament.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerRequest {

    @NotBlank(message = "Name must not be blank")
    private String name;

    @Min(value = 1, message = "Level must be at least 1")
    private int level;

    @Min(value = 0, message = "Health must not be negative")
    private int health;

    @Min(value = 0, message = "Strength must not be negative")
    private int strength;

    @Min(value = 0, message = "Defense must not be negative")
    private int defense;

    @Min(value = 0, message = "Speed must not be negative")
    private int speed;
}
