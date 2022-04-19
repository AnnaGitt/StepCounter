import java.util.HashMap;
import java.util.Map;

public class StepCounter {
    private Map<Integer, Integer> stepsPerDay = new HashMap<>();

    public void add(int day, int steps) {
        if (day <= 0 || steps < 0) {
            return;
        }
        if (stepsPerDay.containsKey(day)) {
            stepsPerDay.put(day, stepsPerDay.get(day) + steps);
        } else {
            stepsPerDay.put(day, steps);
        }
    }

    public int StepsToIncreaseMax(int wantedDay) {
        int maxNumOfSteps = 0;
        for (int day : stepsPerDay.keySet()) {
            if (maxNumOfSteps > stepsPerDay.get(day)) {
                continue;
            } else {
                maxNumOfSteps = stepsPerDay.get(day);
            }
        }
        if(maxNumOfSteps<=stepsPerDay.get(wantedDay)){
            return 0;
        }
        return maxNumOfSteps - stepsPerDay.get(wantedDay);
    }


}
