package ua.com.foxminded.division;

import java.util.Scanner;
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
        int dividend = 0;
        int divisor = 0;
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter dividend");
            dividend = in.nextInt();
            System.out.println("Enter divisor");
            divisor = in.nextInt();
        }
        System.out.println(divisionCalculator.calculate(dividend, divisor));
    }
}
