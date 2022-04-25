import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class StepCounter implements Comparable<StepCounter> {
    private Map<Integer, Integer> stepsPerDay = new HashMap<>();

    public Map<Integer, Integer> getStepsPerDay() {
        return stepsPerDay;
    }

    public void add(int day, int steps) {
        if (day <= 0 || day > 365) {
            throw new IllegalDayException(day);
        }
        if (steps < 0) {
            throw new IllegalStepsException(steps);
        }
        if (stepsPerDay.containsKey(day)) {
            stepsPerDay.put(day, stepsPerDay.get(day) + steps);
        } else {
            stepsPerDay.put(day, steps);
        }
    }

    public int stepsToIncreaseMax(int wantedDay) {
        if (!stepsPerDay.containsKey(wantedDay)) {
            throw new IllegalDayException(wantedDay);
        }
        int maxNumOfSteps = 0;
        for (int day : stepsPerDay.keySet()) {
            if (maxNumOfSteps > stepsPerDay.get(day)) {
                continue;
            } else {
                maxNumOfSteps = stepsPerDay.get(day);
            }
        }
        if (maxNumOfSteps <= stepsPerDay.get(wantedDay)) {
            return 0;
        }
        return maxNumOfSteps - stepsPerDay.get(wantedDay);
    }

    public int sumSteps() {
        int sumSteps = 0;
        for (int day : stepsPerDay.keySet()) {
            sumSteps += stepsPerDay.get(day);
        }
        return sumSteps;
    }

    public int daysWithStepsMoreMin(int min) {
        int StepsMoreMin = 0;
        for (int day : stepsPerDay.keySet()) {
            if (stepsPerDay.get(day) > min) {
                StepsMoreMin++;
            }
        }
        return StepsMoreMin;
    }

    @Override
    public int compareTo(StepCounter stepCounter) {
        return sumSteps() - stepCounter.sumSteps();
    }

    public List<String> printAllDaysByCriteria(Predicate<Integer> criteria) {
        List<String> daysByCriteria = new ArrayList<>();
        for (int days : stepsPerDay.keySet()) {
            if (criteria.test(stepsPerDay.get(days))) {
                daysByCriteria.add("День " + days + " кол-во шагов: " + stepsPerDay.get(days));
            }
        }
        System.out.println(daysByCriteria);
        return daysByCriteria; //Возвращаю arrayList для проверках в тесте
    }
}

