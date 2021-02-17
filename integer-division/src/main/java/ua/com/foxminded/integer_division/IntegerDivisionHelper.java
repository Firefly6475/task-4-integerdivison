package ua.com.foxminded.integer_division;

public class IntegerDivisionHelper {

    private IntegerDivisionHelper() {
        throw new IllegalStateException("Utility class");
    }

    public static int divideInteger(int dividend, int divisor) {
        return dividend / divisor;
    }
}
