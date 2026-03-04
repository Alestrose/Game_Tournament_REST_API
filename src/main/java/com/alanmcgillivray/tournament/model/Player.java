package com.alanmcgillivray.tournament.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
