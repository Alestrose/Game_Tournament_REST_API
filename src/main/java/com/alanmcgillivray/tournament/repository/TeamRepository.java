package com.alanmcgillivray.tournament.repository;

import com.alanmcgillivray.tournament.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}