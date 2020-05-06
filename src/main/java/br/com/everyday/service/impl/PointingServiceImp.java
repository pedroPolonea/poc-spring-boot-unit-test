package br.com.everyday.service.impl;

import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everyday.entity.AppointedDay;
import br.com.everyday.entity.Pointing;
import br.com.everyday.repository.PointingRepository;
import br.com.everyday.service.PointingService;
import exceptions.DefaultException;

@Service
public class PointingServiceImp implements PointingService{

	@Autowired
	private PointingRepository pointingRepository;
	
	public List<Pointing> getAll(AppointedDay appointedDay) {
		return pointingRepository.findByAppointedDay(appointedDay);
	}

	public Pointing save(Pointing pointing) throws Exception {
		
		String validateException = validatePointingException(pointing);
		
		if(!Strings.isEmpty(validateException)) {
			throw new DefaultException(validateException);
		}
		
		return pointingRepository.save(pointing);
	}

	private String validatePointingException(Pointing pointing) throws Exception {
		if(pointing == null) {
			return "Pointing null.";
		}
		
		if(pointing.getAppointedDay() == null) {
			return "AppointedDay not associated.";
		}
		
		return "";
	}
	
	private String validatePointingException(Pointing pointing, AppointedDay appointedDay) throws Exception {
		if(appointedDay == null) {
			return "AppointedDay null.";
		}
		
		if(pointing == null) {
			return "Pointing null.";
		}
		
		return "";
	}

	public void save(Pointing pointing, AppointedDay appointedDay) throws Exception {
		String validateException = validatePointingException(pointing, appointedDay);
		
		if(!Strings.isEmpty(validateException)) {
			throw new DefaultException(validateException);
		}
		
		pointing.setAppointedDay(appointedDay);
		pointingRepository.save(pointing);	
	}


}
