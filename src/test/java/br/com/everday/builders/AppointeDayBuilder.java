package br.com.everday.builders;

import java.time.LocalDate;
import java.time.Month;

import br.com.everyday.entity.AppointedDay;

public class AppointeDayBuilder {
	private AppointedDay appointedDay;


	public AppointeDayBuilder() {
		appointedDay = new AppointedDay();
	}
	
	public static AppointeDayBuilder oneAppointeBuilder() {
		AppointeDayBuilder builder = new AppointeDayBuilder();
		
		builder.appointedDay.setCostCenter(CostCenterBuilder.oneCostCenter().getCostCenter());
		builder.appointedDay.setMotivation(MotivationBuilder.oneMotivation().getMotivation());
		builder.appointedDay.setUser(UserBuilder.oneUser().getUser());
		builder.appointedDay.setTeam(TeamBuilder.oneTeam().getTeam());
		builder.appointedDay.setDay(LocalDate.of(2018, Month.SEPTEMBER, 10));
		builder.appointedDay.setId(1L);
		builder.appointedDay.setPointings(PointingBuilder.onePointings());
		return builder;
	}

	public static AppointeDayBuilder onlyId() {
		AppointeDayBuilder builder = new AppointeDayBuilder();
		builder.appointedDay.setId(1L);
		return builder;
	}
	
	
	public AppointeDayBuilder setTwoPointings() {
		appointedDay.setPointings(PointingBuilder.twoPointings());
		return this;
	}
	
	public AppointedDay getAppointedDay() {
		return appointedDay;
	}
}
