import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class StepCounterCompareTest {
    @ParameterizedTest(name = "{index} {0}")
    @CsvFileSource(resources = "stepCountersCompareToSumSteps.csv")
    public void stepCountersCompareToSumSteps(String title, int day, int steps1,
                                              int steps2, int expected) {
        StepCounter stepCounter1 = new StepCounter();
        StepCounter stepCounter2 = new StepCounter();

        stepCounter1.add(day, steps1);
        stepCounter1.add(day + 1, steps1 + 100);

        stepCounter2.add(day, steps2);
        stepCounter2.add(day + 1, steps2 + 100);

        int answer = stepCounter1.compareTo(stepCounter2);
        int actual;
        if (answer < 0) {
            actual = -1;
        } else if (answer > 0) {
            actual = 1;
        } else {
            actual = 0;
        }
        Assertions.assertEquals(expected, actual);

    }

    @ParameterizedTest(name = "{index} {0}")
    @CsvFileSource(resources = "stepCounterComparator.csv")
    public void stepCountersComparator(String title, int day, int min,
                                       int steps1, int steps2, int expected) {
        StepCounter stepCounter1 = new StepCounter();
        StepCounter stepCounter2 = new StepCounter();

        stepCounter1.add(day, steps1);
        stepCounter1.add(day + 1, steps1 + 100);
        stepCounter1.add(day + 2, steps1 + 150);
        stepCounter1.add(day + 3, steps1 - 100);

        stepCounter2.add(day, steps2);
        stepCounter2.add(day + 1, steps2 + 100);
        stepCounter2.add(day + 2, steps2 + 150);
        stepCounter2.add(day + 3, steps2 - 100);

        StepCounterComparator stpCountCompar = new StepCounterComparator(min);
        int answer = stpCountCompar.compare(stepCounter1, stepCounter2);
        int actual;
        if (answer < 0) {
            actual = -1;
        } else if (answer > 0) {
            actual = 1;
        } else {
            actual = 0;
        }
        Assertions.assertEquals(expected, actual);

    }


}
