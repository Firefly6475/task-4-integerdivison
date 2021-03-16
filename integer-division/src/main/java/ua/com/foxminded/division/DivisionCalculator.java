package ua.com.foxminded.division;

import java.util.List;
import ua.com.foxminded.division.domain.DivisionStep;
import ua.com.foxminded.division.provider.DivisionMathProvider;
import ua.com.foxminded.division.provider.DivisionViewProvider;
import ua.com.foxminded.division.validator.Validator;

public class DivisionCalculator {
    private final Validator validator;
    private final DivisionMathProvider mathProvider;
    private final DivisionViewProvider viewProvider;

    public DivisionCalculator(Validator validator, DivisionMathProvider mathProvider, DivisionViewProvider viewProvider) {
        this.validator = validator;
        this.mathProvider = mathProvider;
        this.viewProvider = viewProvider;
    }

    public String calculate(int dividend, int divisor) {

        validator.validate(dividend, divisor);
        List<DivisionStep> steps = mathProvider.provideMathCalculation(dividend, divisor);

        return viewProvider.provideView(dividend, divisor, steps);
    }
}
