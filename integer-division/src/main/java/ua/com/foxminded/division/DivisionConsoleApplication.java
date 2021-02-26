package ua.com.foxminded.division;

import ua.com.foxminded.division.provider.DivisionMathProvider;
import ua.com.foxminded.division.provider.DivisionViewProvider;
import ua.com.foxminded.division.provider.impl.DivisionMathService;
import ua.com.foxminded.division.provider.impl.DivisionViewService;
import ua.com.foxminded.division.validator.Validator;
import ua.com.foxminded.division.validator.ValidatorImpl;

public class DivisionConsoleApplication {
    public static void main(String[] args) {
        Validator validator = new ValidatorImpl();
        DivisionMathProvider divisionMathProvider = new DivisionMathService();
        DivisionViewProvider divisionViewProvider = new DivisionViewService();

        DivisionCalculator divisionCalculator =
                new DivisionCalculator(validator, divisionMathProvider, divisionViewProvider);
        System.out.print(divisionCalculator.calculate(78945, 4));
    }
}
