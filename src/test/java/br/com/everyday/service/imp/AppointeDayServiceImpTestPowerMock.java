package br.com.everyday.service.imp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import br.com.everyday.service.impl.AppointeDayServiceImp;
import exceptions.DefaultException;

public class AppointeDayServiceImpTestPowerMock {
	
	@InjectMocks
	private AppointeDayServiceImp appointeDayServiceMock;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void x() throws DefaultException {
		
	}
	
}
