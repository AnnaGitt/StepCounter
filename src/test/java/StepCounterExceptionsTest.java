import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StepCounterExceptionsTest {
    @Test
    public void addNegativeDayException() {
        StepCounter stepCounter = new StepCounter();
        Assertions.assertThrows(IllegalDayException.class, () -> stepCounter.add(-1, 10));
    }

    @Test
    public void add366DayException() {
        StepCounter stepCounter = new StepCounter();
        Assertions.assertThrows(IllegalDayException.class, () -> stepCounter.add(366, 10));
    }

    @Test
    public void addNegativeStepsException() {
        StepCounter stepCounter = new StepCounter();
        Assertions.assertThrows(IllegalStepsException.class, () -> stepCounter.add(1, -10));
    }

    @Test
    public void stepsToIncreaseMaxException() {
        StepCounter stepCounter = new StepCounter();
        Assertions.assertThrows(IllegalDayException.class, () -> stepCounter.stepsToIncreaseMax(-1));
    }
}
