public class IllegalDayException extends RuntimeException {
    public IllegalDayException(int day) {
        super("Day not exists or your parameter is a negative value" +
                " or value more than 365. Your value: " + day);
    }
}
