package com.alanmcgillivray.tournament.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamRequest {

    @NotBlank(message = "Team name must not be blank")
    private String name;
}