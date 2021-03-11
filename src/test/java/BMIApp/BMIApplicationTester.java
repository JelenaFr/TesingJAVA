package BMIApp;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class BMIApplicationTester {
    //@InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    BMIApplication bmiApplication = new BMIApplication();

    //@Mock annotation is used to create the mock object to be injected
    @Mock
    BMIService bmiService;

    @Test
    public void testCalcMyBMP() {
        //add the behavior of calc BMI
        Mockito.lenient().when(bmiService.calcMyBMI(90.0, 1.5)).thenReturn("Obese");
        //test the calcMyBMP functionality
        Assert.assertEquals(bmiApplication.calcMyBMP(90.0, 1.5), "Obese");
    }
}