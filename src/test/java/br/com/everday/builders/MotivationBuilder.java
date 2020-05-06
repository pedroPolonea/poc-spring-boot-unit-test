package br.com.everday.builders;

import java.time.LocalDateTime;

import br.com.everyday.entity.Motivation;

public class MotivationBuilder {
	private Motivation motivation;
	
	public Motivation getMotivation() {
		return motivation;
	}

	public MotivationBuilder() {
		motivation = new Motivation();
	}
	
	public static MotivationBuilder oneMotivation() {
		MotivationBuilder motivationBuilder = new MotivationBuilder();
		motivationBuilder.motivation.setId(1L);
		motivationBuilder.motivation.setName("Banco de Horas");
		motivationBuilder.motivation.setActive(true);
		motivationBuilder.motivation.setDataCreation(LocalDateTime.now());
		
		return motivationBuilder;
		
	}
}
