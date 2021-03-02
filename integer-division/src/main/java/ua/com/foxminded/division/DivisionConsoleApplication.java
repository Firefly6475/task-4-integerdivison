package ua.com.foxminded.division;

import ua.com.foxminded.division.provider.DivisionMathProvider;
import ua.com.foxminded.division.provider.DivisionViewProvider;
import ua.com.foxminded.division.provider.impl.DivisionMathImpl;
import ua.com.foxminded.division.provider.impl.DivisionViewImpl;
import ua.com.foxminded.division.validator.Validator;
import ua.com.foxminded.division.validator.ValidatorImpl;

public class DivisionConsoleApplication {
    public static void main(String[] args) {
        Validator validator = new ValidatorImpl();
        DivisionMathProvider divisionMathProvider = new DivisionMathImpl();
        DivisionViewProvider divisionViewProvider = new DivisionViewImpl();

        DivisionCalculator divisionCalculator =
                new DivisionCalculator(validator, divisionMathProvider, divisionViewProvider);
        System.out.print(divisionCalculator.calculate(78945, 4));
    }
}
