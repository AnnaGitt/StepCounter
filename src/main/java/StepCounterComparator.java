import java.util.Comparator;

public class StepCounterComparator implements Comparator<StepCounter> {
    private int minStepsPerDay;

    public StepCounterComparator(int minStepsPerDay) {
        if (minStepsPerDay < 0) {
            this.minStepsPerDay = 0;
        } else {
            this.minStepsPerDay = minStepsPerDay;
        }
    }

    @Override
    public int compare(StepCounter sC1, StepCounter sC2) {
        return sC1.DaysWithStepsMoreMin(minStepsPerDay) - sC2.DaysWithStepsMoreMin(minStepsPerDay);
    }
}
