package FizzBuzzApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FizzBuzzTest {

    //@InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    FizzBuzz fizzBuzz = new FizzBuzz();
    @Mock
    FizzBuzzService fizzBuzzService;

    @Test
    public void testMultipleOfThreeAndFivePrintsFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(150));
    }

    @Test
    public void testMultipleOfThreeOnlyPrintsFizz() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(93));
    }

    @Test
    public void testMultipleOfFiveOnlyPrintsBuzz() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(10));
    }

    @Test
    public void testInputOfEightPrintsTheNumber() {
        assertEquals("8", FizzBuzz.fizzBuzz(8));
    }

    @Test
    public void testOutputOfProgramIsANonEmptyString() {
        String out = FizzBuzz.buildOutput(1);
        assertNotNull(out);
        assertNotSame(0, out.length());
    }
}
