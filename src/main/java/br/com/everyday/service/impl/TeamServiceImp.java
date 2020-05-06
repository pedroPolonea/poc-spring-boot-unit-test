package br.com.everyday.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everyday.entity.Team;
import br.com.everyday.repository.TeamRepository;
import br.com.everyday.service.TeamService;
@Service
public class TeamServiceImp implements TeamService {
	@Autowired
	private TeamRepository teamRepository;
	
	public List<Team> getAll() {
		return teamRepository.findAll();
	}

}
