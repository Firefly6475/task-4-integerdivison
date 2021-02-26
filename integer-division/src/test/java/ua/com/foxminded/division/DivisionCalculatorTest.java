package ua.com.foxminded.division;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.division.provider.DivisionMathProvider;
import ua.com.foxminded.division.provider.DivisionViewProvider;
import ua.com.foxminded.division.provider.impl.DivisionMathService;
import ua.com.foxminded.division.provider.impl.DivisionViewService;
import ua.com.foxminded.division.validator.Validator;
import ua.com.foxminded.division.validator.ValidatorImpl;

public class DivisionCalculatorTest {

    Validator validator = new ValidatorImpl();
    DivisionMathProvider divisionMathProvider = new DivisionMathService();
    DivisionViewProvider divisionViewProvider = new DivisionViewService();

    DivisionCalculator divisionCalculator =
            new DivisionCalculator(validator, divisionMathProvider, divisionViewProvider);

    @Test
    void validateShouldThrowIllegalArgumentExceptionIfDivisorIsZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            divisionCalculator.calculate(29152, 0);
        });

        String expectedMessage = "Argument divisor is 0";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void validateShouldThrowIllegalArgumentExceptionIfDividendIsZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            divisionCalculator.calculate(0, 1234125);
        });

        String expectedMessage = "Argument dividend is 0";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void calculateShouldReturnLongDivision() {
        String expectedCalculation = "_78945|4\n" + " 4    |-----\n" + " -    |19736\n" + "_38\n"
                + " 36\n" + " --\n" + " _29\n" + "  28\n" + "  --\n" + "  _14\n" + "   12\n"
                + "   --\n" + "   _25\n" + "    24\n" + "    --\n" + "     1";
        String actualCalculation = divisionCalculator.calculate(78945, 4);

        assertEquals(expectedCalculation, actualCalculation);
    }
}
