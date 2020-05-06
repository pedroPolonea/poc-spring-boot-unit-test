package br.com.everyday.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everyday.entity.Motivation;
import br.com.everyday.repository.MotivationRepository;
import br.com.everyday.service.MotivationService;

@Service
public class MotivationServiceImp implements MotivationService {

	@Autowired
	private MotivationRepository motivationRepository;
	
	public List<Motivation> getAll() {
		return motivationRepository.findAll();
	}

}
