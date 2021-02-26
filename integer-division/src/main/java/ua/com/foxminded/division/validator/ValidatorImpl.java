package ua.com.foxminded.division.validator;

public class ValidatorImpl implements Validator {
    @Override
    public void validate(int dividend, int divisor) {
        if (dividend == 0) {
            throw new IllegalArgumentException("Argument dividend is 0");
        }
        if (divisor == 0) {
            throw new IllegalArgumentException("Argument divisor is 0");
        }
    }
}
