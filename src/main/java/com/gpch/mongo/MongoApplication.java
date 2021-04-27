package com.gpch.mongo;

import com.gpch.mongo.model.Player;
import com.gpch.mongo.service.*;

import com.gpch.mongo.model.Manager;

import com.gpch.mongo.model.Legend;

import com.gpch.mongo.model.Team;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


//pus
import com.gpch.mongo.model.Role;
import com.gpch.mongo.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Slf4j
public class MongoApplication {



	public static void main(String[] args) {
		SpringApplication.run(MongoApplication.class, args);
	}

	//Lista jucatori

	@Bean
	public CommandLineRunner setupPlayer(PlayerService playerService) {
		return (args) -> {
			log.info("Generating sample data");
//			playerService.deleteAllPlayers();
			List<String> players = Arrays.asList();

			players.forEach(player ->
					playerService.savePlayer(Player.builder()
							.name(player)
							.team(player)
							.transfer(player)
							.rating(player)
							.nation(player)
							.date(LocalDateTime.now())
							.build()));

			playerService.getAllPlayers().forEach(player ->
					log.info("PLAYERS --> " + player.getName() + player.getTeam() + player.getNation() +
							player.getTransfer() + player.getTransfer() + " ID: " + player.getId()));
			playerService.saveAll(players); //pus de mn
		};

	}

	//Lista manageri

	@Bean
	public CommandLineRunner setupManager(ManagerService managerService) {
		return (args) -> {
			log.info("Generating sample data");
			List<String> managers = Arrays.asList();

			managers.forEach(manager ->
					managerService.saveManager(Manager.builder()
							.name(manager)
							.team(manager)
							.age(manager)
							.status(manager)
							.nation(manager)
							.date(LocalDateTime.now())
							.build()));

			managerService.getAllManagers().forEach(manager ->
					log.info("MANAGERS --> " + manager.getName() + manager.getTeam() + manager.getStatus() +
							manager.getAge() + manager.getNation() + " ID: " + manager.getId()));
			managerService.saveAll(managers); //pus de mn
		};

	}


	//Lista legende

	@Bean
	public CommandLineRunner setupLegend(LegendService legendService) {
		return (args) -> {
			log.info("Generating sample data");
			List<String> legends = Arrays.asList();

			legends.forEach(legend ->
					legendService.saveLegend(Legend.builder()
							.name(legend)
							.team(legend)
							.fieldPosition(legend)
							.rating(legend)
							.date(LocalDateTime.now())
							.build()));

			legendService.getAllLegends().forEach(legend ->
					log.info("LEGENDS --> " + legend.getName() + legend.getTeam() +
							legend.getFieldPosition() + legend.getRating() + " ID: " + legend.getId()));
			legendService.saveAll(legends); //pus de mn
		};

	}


	//lista teams


	@Bean
	public CommandLineRunner setupTeam(TeamService teamService) {
		return (args) -> {
			log.info("Generating sample data");
			List<String> teams = Arrays.asList();

			teams.forEach(team ->
					teamService.saveTeam(Team.builder()
							.teamName(team)
							.teamCountry(team)
							.teamLeague(team)
							.worldRating(team)
							.teamStadium(team)
							.date(LocalDateTime.now())
							.build()));

			teamService.getAllTeams().forEach(team ->
					log.info("TEAMS --> " + team.getTeamName() + team.getTeamCountry() +
							team.getTeamLeague() + team.getWorldRating() + team.getTeamStadium() + " ID: " + team.getId()));
			teamService.saveAll(teams); //pus de mn
		};

	}

	

	@Bean
	CommandLineRunner init(RoleRepository roleRepository) {

		return args -> {

			Role adminRole = roleRepository.findByRole("ADMIN");
			if (adminRole == null) {
				Role newAdminRole = new Role();
				newAdminRole.setRole("ADMIN");
				roleRepository.save(newAdminRole);
			}

			Role userRole = roleRepository.findByRole("USER");
			if (userRole == null) {
				Role newUserRole = new Role();
				newUserRole.setRole("USER");
				roleRepository.save(newUserRole);
			}
		};

	}
	}
