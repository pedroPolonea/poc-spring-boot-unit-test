package br.com.everday.builders;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import br.com.everyday.entity.Pointing;

public class PointingBuilder {
	private Pointing pointing;
	private static List<Pointing> pointings;
	

	public PointingBuilder() {}
	
	public static PointingBuilder onePointingMorning() {
		PointingBuilder builder = new PointingBuilder();
		builder.pointing = new Pointing();
		
		builder.pointing.setId(1L);
		builder.pointing.setDateInput(LocalDateTime.of(2018, Month.SEPTEMBER, 10, 8, 0));
		builder.pointing.setDateOutput(LocalDateTime.of(2018, Month.SEPTEMBER, 10, 12, 0));
		
		return builder;
	}
	
	public static PointingBuilder onePointingAfternoon() {
		PointingBuilder builder = new PointingBuilder();
		builder.pointing = new Pointing();
		
		builder.pointing.setId(2L);
		builder.pointing.setDateInput(LocalDateTime.of(2018, Month.SEPTEMBER, 10, 13, 0));
		builder.pointing.setDateOutput(LocalDateTime.of(2018, Month.SEPTEMBER, 10, 19, 0));
		
		return builder;
	}
	
	public static List<Pointing> onePointings() {
		pointings = new ArrayList<Pointing>();
		pointings.add(onePointingMorning().pointing);
		
		return pointings;
	}
	
	public static List<Pointing> twoPointings() {
		pointings = new ArrayList<Pointing>();
		pointings.add(onePointingMorning().pointing);
		pointings.add(onePointingAfternoon().pointing);
		
		return pointings;
	}
	
	public Pointing getPointing() {
		return pointing;
	}
	
	
}
