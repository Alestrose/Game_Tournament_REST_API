package com.alanmcgillivray.tournament.repository;

import com.alanmcgillivray.tournament.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
