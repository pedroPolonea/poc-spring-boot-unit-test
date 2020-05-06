package br.com.everyday.service;

import java.time.Duration;
import java.util.List;

import br.com.everyday.entity.AppointedDay;
import br.com.everyday.entity.User;
import exceptions.DefaultException;

public interface AppointedDayService {
	public List<AppointedDay> getAll(User user);
	
	public Duration totalAmountOfHours(AppointedDay appointedDay) throws DefaultException;

}
