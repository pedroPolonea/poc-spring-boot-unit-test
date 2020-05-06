package br.com.everyday.service;

import java.util.List;

import br.com.everyday.entity.AppointedDay;
import br.com.everyday.entity.Pointing;

public interface PointingService {
	public List<Pointing> getAll(AppointedDay appointedDay);
	
	public Pointing save(Pointing pointing)throws Exception;

}
