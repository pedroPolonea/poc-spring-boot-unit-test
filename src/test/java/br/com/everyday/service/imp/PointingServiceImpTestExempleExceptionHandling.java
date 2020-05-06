package br.com.everyday.service.imp;

import br.com.everday.builders.PointingBuilder;
import br.com.everyday.Matchers.ErrorMessageMatcher;
import br.com.everyday.service.impl.PointingServiceImp;
import exceptions.DefaultException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class PointingServiceImpTestExempleExceptionHandling {

    @InjectMocks
    private PointingServiceImp pointingServiceImp;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * @throws Exception The generic form already expected an exception, this form of treatment has as
     *    	 * disadvantage of the little control of the test scenario.
     */
    @Test(expected = DefaultException.class)
    public void genericShapeExceptionHandlingExample() throws Exception {
        pointingServiceImp.save(null);
    }

    /**
     * @throws Exception This form of treatment allows a greater control of the scenario because we were able to verify
     * the message generated in the exception.
     */
    @Test
    public void exampleOfExcepcExceptionHandlingNotComplete() throws Exception {

        exception.expect(DefaultException.class);
        exception.expectMessage("Pointing null.");

        pointingServiceImp.save(null);

    }

    /**
     * @throws Exception This form of treatment allows a greater control of the scenario because we were able to verify
     * the message generated in the exception.
     */
    @Test
    public void exampleOfExcepcExceptionHandlingNotCompleteMatcher() throws Exception {
        final String exceptionMessage = "Pointing null.";

        exception.expect(Exception.class);
        final ErrorMessageMatcher<Exception> matcher = new ErrorMessageMatcher<>(exceptionMessage);
        exception.expect(matcher.match());

        pointingServiceImp.save(null);
    }

    /**
     * The robust form allows full control of the scenario, in this form of
     * exetion treatment we have the control in case the exception is not thrown through the fail.
     */
    @Test
    public void exampleOfRobustExceptionHandling() {
        try {
            pointingServiceImp.save(PointingBuilder.onePointingMorning().getPointing());
            Assert.fail();
        } catch (Exception e) {
            Assert.assertEquals("AppointedDay not associated.", e.getMessage());
        }
    }

}
