import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StepCounterTest {
    @Test
    public void stepsToIncreaseMaxDay1Steps1000 (){
        StepCounter stepCounter = new StepCounter();
        stepCounter.add(1, 1000);
        stepCounter.add(2, 800);
        stepCounter.add(3, 1500);
        int expected = 500;
        int actual = stepCounter.StepsToIncreaseMax(1);
        Assertions.assertEquals(actual,expected);
    }

    @Test
    public void stepsToIncreaseMaxDay3Steps1500 (){
        StepCounter stepCounter = new StepCounter();
        stepCounter.add(1, 1000);
        stepCounter.add(2, 800);
        stepCounter.add(3, 1500);
        int expected = 0;
        int actual = stepCounter.StepsToIncreaseMax(3);
        Assertions.assertEquals(actual,expected);
    }
}
