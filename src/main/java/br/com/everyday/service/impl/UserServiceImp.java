package br.com.everyday.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everyday.entity.User;
import br.com.everyday.repository.UserRepository;
import br.com.everyday.service.UserService;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
}
