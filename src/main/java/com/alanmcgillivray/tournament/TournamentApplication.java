package com.alanmcgillivray.tournament;

import com.alanmcgillivray.tournament.model.Player;
import com.alanmcgillivray.tournament.service.PlayerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TournamentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TournamentApplication.class, args);
	}

	@Bean
	CommandLineRunner testService(PlayerService playerService){
		return args -> {

			Player p = new Player();
			p.setName("Knight");
			p.setLevel(1);
			p.setHealth(100);
			p.setStrength(20);
			p.setDefense(15);
			p.setSpeed(10);

			playerService.createPlayer(p);

			System.out.println("Player created the Service layer.");
		};
	}

}
