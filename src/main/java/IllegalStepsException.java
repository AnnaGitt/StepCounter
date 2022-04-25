public class IllegalStepsException extends RuntimeException{
    public IllegalStepsException(int steps) {
        super("Number of Steps cannot be negative. Your value: " + steps);
    }
}
