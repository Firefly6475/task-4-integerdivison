package ua.com.foxminded.division.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ValidatorImplTest {
    Validator validator = new ValidatorImpl();

    @Test
    void validateShouldThrowIllegalArgumentExceptionIfDivisorIsZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validate(29152, 0);
        });

        String expectedMessage = "Argument divisor is 0 or negative";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void validateShouldThrowIllegalArgumentExceptionIfDivisorIsNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validate(29152, -523);
        });

        String expectedMessage = "Argument divisor is 0 or negative";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void validateShouldThrowIllegalArgumentExceptionIfDividendIsNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.validate(-2, 1234125);
        });

        String expectedMessage = "Argument dividend is negative";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }


}
