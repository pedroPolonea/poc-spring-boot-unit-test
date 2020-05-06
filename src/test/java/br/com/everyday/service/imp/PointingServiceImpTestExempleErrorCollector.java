package br.com.everyday.service.imp;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.everday.builders.AppointeDayBuilder;
import br.com.everday.builders.PointingBuilder;
import br.com.everyday.Matchers.MatchersCustom;
import br.com.everyday.entity.Pointing;
import br.com.everyday.repository.PointingRepository;
import br.com.everyday.service.impl.PointingServiceImp;

public class PointingServiceImpTestExempleErrorCollector {
	
	@InjectMocks
	private PointingServiceImp  pointingServiceImp;
	
	@Mock
	private PointingRepository pointingRepository;
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	

	/**
	 * @throws Exception
	 * Basic example of using ErrorCollector and MatchersCustom
	 */
	@Test
	public void exampleOfUsingErrorCollectorAndMatchersCustom() throws Exception {
		Pointing pointingSave;
		Pointing pointing = PointingBuilder.onePointingAfternoon().getPointing();
		pointing.setAppointedDay(AppointeDayBuilder.onlyId().getAppointedDay());
		Mockito.when(pointingRepository.save(pointing)).thenReturn(pointing);
		
		pointingSave = pointingServiceImp.save(pointing);
		
		error.checkThat("Pointing save null.",pointingSave, CoreMatchers.notNullValue());
		error.checkThat("Pointing save different", pointingSave, CoreMatchers.equalTo(pointing));
		error.checkThat(pointingSave.getDateInput(), MatchersCustom.isBefore(pointingSave.getDateOutput()));
	}
	
}
