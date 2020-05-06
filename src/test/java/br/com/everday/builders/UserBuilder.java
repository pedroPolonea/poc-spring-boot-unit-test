package br.com.everday.builders;

import java.time.LocalDateTime;

import br.com.everyday.entity.User;

public class UserBuilder {
	private User user;
	
	public UserBuilder() {
		user = new User();
	}
	
	public static UserBuilder oneUser() {
		UserBuilder userBuilder = new UserBuilder();
		userBuilder.user.setActive(true);
		userBuilder.user.setId(1L);
		userBuilder.user.setLogin("Snow");
		userBuilder.user.setPassword("1234");
		userBuilder.user.setName("Jon Snow");
		userBuilder.user.setDataCreation(LocalDateTime.now());
		
		return userBuilder;		
	}

	public User getUser() {
		return user;
	}
	
}
