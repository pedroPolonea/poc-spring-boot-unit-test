package br.com.everyday.service.imp;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import br.com.everday.builders.AppointeDayBuilder;
import br.com.everyday.entity.AppointedDay;
import br.com.everyday.service.impl.AppointeDayServiceImp;
import exceptions.DefaultException;

@RunWith(Parameterized.class)
public class AppointeDayServiceImpTestParameterized {
	
	@InjectMocks
	private AppointeDayServiceImp appointeDayServiceMock;
	
	@Parameter(value=0)
	public AppointedDay appointedDay;
	@Parameter(value=1)
	public Duration durationHours;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Parameters
	public static Collection<Object[]> getParameter(){
		return Arrays.asList(new Object[][] {
			{AppointeDayBuilder.oneAppointeBuilder().getAppointedDay(), Duration.ofHours(4)},
			{AppointeDayBuilder.oneAppointeBuilder().setTwoPointings().getAppointedDay(), Duration.ofHours(10)}
		});
	}
	
	@Test
	public void exampleOfParameterizedTestWithPredefinedResultInTheScenario() throws DefaultException {
		Duration totalAmountOfHours = appointeDayServiceMock.totalAmountOfHours(appointedDay);
		Assert.assertEquals(totalAmountOfHours, durationHours);
	}
	
	@Test
	public void exampleOfParameterizedTestWithFailure() throws DefaultException {
		Duration totalAmountOfHours = appointeDayServiceMock.totalAmountOfHours(appointedDay);
		Assert.assertNotEquals(totalAmountOfHours, Duration.ZERO);
	}
}
