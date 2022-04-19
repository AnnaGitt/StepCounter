import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.HashMap;
import java.util.Map;

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
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void stepsToIncreaseMaxEqual (){
        StepCounter stepCounter = new StepCounter();
        stepCounter.add(1, 1000);
        stepCounter.add(2, 800);
        stepCounter.add(3, 1000);
        int expected = 0;
        int actual = stepCounter.StepsToIncreaseMax(1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void stepsToIncreaseMaxAll0 (){
        StepCounter stepCounter = new StepCounter();
        stepCounter.add(1, 0);
        stepCounter.add(2, 0);
        stepCounter.add(3, 0);
        int expected = 0;
        int actual = stepCounter.StepsToIncreaseMax(1);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "{index} {0}")
    @CsvFileSource(resources = "addDay.csv")
    public void addDay (String title, int day, int steps, boolean expected) {
        StepCounter stepCounter = new StepCounter();
        stepCounter.add(day,steps);
        Map<Integer,Integer> actualMap = new HashMap<>(stepCounter.getStepsPerDay());
        boolean actual = actualMap.containsKey(day);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void addSameDay () {
        StepCounter stepCounter = new StepCounter();
        stepCounter.add(1,1000);
        stepCounter.add(1,1500);
        Map<Integer,Integer> actualMap = new HashMap<>(stepCounter.getStepsPerDay());
        int expected = 2500;
        int actual = actualMap.get(1);
        Assertions.assertEquals(expected,actual);
    }
}
