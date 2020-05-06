package br.com.everyday.service.impl;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everyday.entity.AppointedDay;
import br.com.everyday.entity.Pointing;
import br.com.everyday.entity.User;
import br.com.everyday.repository.AppointedDayRepository;
import br.com.everyday.service.AppointedDayService;
import exceptions.DefaultException;

@Service
public class AppointeDayServiceImp implements AppointedDayService {

	@Autowired
	private AppointedDayRepository appointedDayRepository;
	
	public List<AppointedDay> getAll(User user) {
		
		return appointedDayRepository.findByUser(user);
	}

	public Duration totalAmountOfHours(AppointedDay appointedDay) throws DefaultException {
		Duration duration = Duration.ZERO;
	
		for (Pointing pointing : appointedDay.getPointings()) {
			duration = getDuration(duration, pointing);
		}
		
		//System.out.printf("Total duration is %sdays %shrs %smin %ssec.\n", duration.toDays(), duration.toHours() % 24, duration.toMinutes() % 60, duration.getSeconds() % 60);
		return duration;
	}

	private Duration getDuration(Duration duration, Pointing pointing) throws DefaultException {
		if(pointing.getDateOutput() == null) {
			String mesage = "Pointing id %s "
					.concat(String.valueOf(pointing.getId())
							.concat(" data output is null."));
			throw new DefaultException(mesage);  
		}
		return duration.plus(Duration.between(pointing.getDateInput(), pointing.getDateOutput()));
	}
	

}


