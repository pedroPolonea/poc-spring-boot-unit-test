package br.com.everyday.service.imp;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.everday.builders.AppointeDayBuilder;
import br.com.everday.builders.PointingBuilder;
import br.com.everyday.entity.Pointing;
import br.com.everyday.repository.PointingRepository;
import br.com.everyday.service.impl.PointingServiceImp;

public class PointingServiceImpTestExempleMoreMockito {
	
	@InjectMocks
	private PointingServiceImp  pointingServiceImp;
	
	@Mock
	private PointingRepository pointingRepository;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * @throws Exception
	 * In this example an exception is generated in this way the save method will never be executed.
	 */
	@Test
	public void exampleOfVerificationOfNonExecutionOfSaveMethod() throws Exception {
		Mockito.verify(pointingRepository, Mockito.never()).save(null);
	}
	
	/**
	 * @throws Exception
	 * The return of the method is being mockado, by means of assert this being verified the return.
	 * This is a basic example of functionality, maybe not the best ...
	 */
	@Test
	public void exampleOfMockadoReturnAndVerificationByAssertThat() throws Exception {
		Pointing pointingSave;
		Pointing pointing = PointingBuilder.onePointingAfternoon().getPointing();
		pointing.setAppointedDay(AppointeDayBuilder.onlyId().getAppointedDay());
		Mockito.when(pointingRepository.save(pointing)).thenReturn(pointing);
		
		pointingSave = pointingServiceImp.save(pointing);
		
		Assert.assertThat(pointingSave, CoreMatchers.equalTo(pointing));
	}
	
	/**
	 * @throws Exception
	 * The return of the method is being mockado, by means of assert this being verified the return.
	 * This is a basic example of functionality, maybe not the best ...
	 */
	@Test
	public void exampleOfMockadoReturnAndVerificationByAssertEquals() throws Exception {
		Pointing pointingSave;
		Pointing pointing = PointingBuilder.onePointingAfternoon().getPointing();
		pointing.setAppointedDay(AppointeDayBuilder.onlyId().getAppointedDay());
		Mockito.when(pointingRepository.save(pointing)).thenReturn(pointing);
		
		pointingSave = pointingServiceImp.save(pointing);
		
		Assert.assertEquals(pointing, pointingSave);
	}
	
	/**
	 * @throws Exception
	 * Checking if the save method is being called at least once.
	 */
	@Test
	public void exampleOfAMockadoReturnAndVerifiesThatAtLeastOnceTheSaveMethodWasExecuted() throws Exception {
		Pointing pointing = PointingBuilder.onePointingAfternoon().getPointing();
		pointing.setAppointedDay(AppointeDayBuilder.onlyId().getAppointedDay());
		Mockito.when(pointingRepository.save(pointing)).thenReturn(pointing);
		
		pointingServiceImp.save(pointing);
		
		Mockito.verify(pointingRepository, Mockito.times(1)).save(pointing);
	}
	
	/**
	 * @throws Exception
	 * In the call or verification of methods Mockados can inform generic types of the class.
	 */
	@Test
	public void exampleOfAMockadoReturnAndVerifiesThatAtLeastOnceTheSaveMethodWasExecutedByAny() throws Exception {
		Pointing pointing = PointingBuilder.onePointingAfternoon().getPointing();
		pointing.setAppointedDay(AppointeDayBuilder.onlyId().getAppointedDay());
		Mockito.when(pointingRepository.save(Mockito.any(Pointing.class))).thenReturn(pointing);
		
		pointingServiceImp.save(pointing);
		
		Mockito.verify(pointingRepository, Mockito.times(1)).save(Mockito.any(Pointing.class));
	}	
	
	/**
	 * @throws Exception
	 * 
	 * Simple example of capturing objects that are changed inside a void method.
	 * We can note that the save method makes changes to the Pointing object, with 
	 * ArgumentCaptor we can capitalize the changes.
	 */
	@Test
	public void basicExampleOfCapituraOfObjectsAlteredInAVoidMethod() throws Exception {
		pointingServiceImp.save(PointingBuilder.onePointingMorning().getPointing(), AppointeDayBuilder.onlyId().getAppointedDay());
	
		ArgumentCaptor<Pointing> captor = ArgumentCaptor.forClass(Pointing.class);
		Mockito.verify(pointingRepository, Mockito.times(1)).save(captor.capture());
		Pointing pointingSave = captor.getValue();
		
		Assert.assertThat(pointingSave.getAppointedDay(), CoreMatchers.notNullValue(null));
	}	
}
