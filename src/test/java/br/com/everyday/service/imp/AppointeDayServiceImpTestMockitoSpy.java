package br.com.everyday.service.imp;

import java.time.Duration;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import br.com.everday.builders.AppointeDayBuilder;
import br.com.everyday.entity.AppointedDay;
import br.com.everyday.service.impl.AppointeDayServiceImp;
import exceptions.DefaultException;

public class AppointeDayServiceImpTestMockitoSpy {
	
	@Mock
	private AppointeDayServiceImp appointeDayServiceMock;
	
	@Spy
	private AppointeDayServiceImp appointeDayServiceSpy;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * @throws DefaultException
	 * In this example we see that the values mockados and informed in the 
	 * function are the memos so we reach the expected result
	 */
	@Test
	public void exampleOfSpyAndMockWitTheSameValuesReported() throws DefaultException {
		AppointedDay appointedDay = AppointeDayBuilder.oneAppointeBuilder().setTwoPointings().getAppointedDay();
		
		Mockito.when(appointeDayServiceMock.totalAmountOfHours(appointedDay)).thenReturn(Duration.ZERO);
		Mockito.when(appointeDayServiceSpy.totalAmountOfHours(appointedDay)).thenReturn(Duration.ZERO);
		
		Duration durationMock = appointeDayServiceMock.totalAmountOfHours(appointedDay);
		Duration durationSpy = appointeDayServiceSpy.totalAmountOfHours(appointedDay);
	
		Assert.assertThat(durationMock, CoreMatchers.equalTo(Duration.ZERO));
		Assert.assertThat(durationSpy, CoreMatchers.equalTo(Duration.ZERO));
	}
	
	/**
	 * @throws DefaultException
	 * In this example we see that the value mockado and the value passed to the totalAmountOfHours function, 
	 * so spy returns the value of the actual calculation of the function and not the value mockado.
	 */
	@Test
	public void exampleOfSpy() throws DefaultException {
		AppointedDay appointedDayTwoPointing = AppointeDayBuilder.oneAppointeBuilder().setTwoPointings().getAppointedDay();
		AppointedDay appointedDayOnePointing = AppointeDayBuilder.oneAppointeBuilder().getAppointedDay();
		Duration duration = Duration.ofHours(6);
		
		Mockito.when(appointeDayServiceSpy.totalAmountOfHours(appointedDayTwoPointing)).thenReturn(duration);
	
		Duration durationSpy = appointeDayServiceSpy.totalAmountOfHours(appointedDayOnePointing);
	
		Assert.assertEquals(Duration.ofHours(4), durationSpy);
	}
	
	/**
	 * @throws DefaultException
	 * In this example we have distinct distinct values assigned to the totalAmountO Hours function, 
	 * in which case the mock object does not know how to behave and returning null.
	 */
	@Test
	public void mockExampleWithDifferentValuesReported() throws DefaultException {
		AppointedDay appointedDayTwoPointing = AppointeDayBuilder.oneAppointeBuilder().setTwoPointings().getAppointedDay();
		AppointedDay appointedDayOnePointing = AppointeDayBuilder.oneAppointeBuilder().getAppointedDay();
		Duration duration = Duration.ofHours(6);
		Mockito.when(appointeDayServiceMock.totalAmountOfHours(appointedDayTwoPointing)).thenReturn(duration);
		
		Duration durationMock = appointeDayServiceMock.totalAmountOfHours(appointedDayOnePointing);
	
		Assert.assertEquals(null, durationMock);
	}
}
