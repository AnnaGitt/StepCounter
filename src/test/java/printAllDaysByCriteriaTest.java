import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class printAllDaysByCriteriaTest {
    @Test
    public void criteriaTenThousands() {
        StepCounter stepCounter = new StepCounter();
        stepCounter.add(1, 14_000);
        stepCounter.add(2, 1500);
        stepCounter.add(3, 2000);
        stepCounter.add(4, 11_000);
        stepCounter.add(5, 15_000);
        stepCounter.add(6, 7000);

        List<String> expected = new ArrayList<>();
        expected.add("День 1 кол-во шагов: 14000");
        expected.add("День 4 кол-во шагов: 11000");
        expected.add("День 5 кол-во шагов: 15000");

        List<String> actual = new ArrayList<>(stepCounter.printAllDaysByCriteria(steps -> steps >= 10_000));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void criteriaTwentyThousands() {
        StepCounter stepCounter = new StepCounter();
        stepCounter.add(1, 14_000);
        stepCounter.add(2, 1500);
        stepCounter.add(3, 2000);
        stepCounter.add(4, 11_000);
        stepCounter.add(5, 15_000);
        stepCounter.add(6, 7000);

        List<String> expected = new ArrayList<>();

        List<String> actual = new ArrayList<>(stepCounter.printAllDaysByCriteria(steps -> steps >= 20_000));

        Assertions.assertEquals(expected, actual);
    }
}
