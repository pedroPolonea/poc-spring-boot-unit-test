package br.com.everday.builders;

import java.time.LocalDateTime;

import br.com.everyday.entity.Team;

public class TeamBuilder {
	private Team team;
	
	public TeamBuilder() {
		team = new Team();
	}
	
	public static TeamBuilder oneTeam() {
		TeamBuilder teamBuilder = new TeamBuilder();
		teamBuilder.team.setActive(true);
		teamBuilder.team.setDataCreation(LocalDateTime.now());
		teamBuilder.team.setId(1L);
		teamBuilder.team.setName("Team Stark");
		
		return teamBuilder;
	}

	public Team getTeam() {
		return team;
	}
}
