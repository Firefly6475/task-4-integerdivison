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
        Scanner in = new Scanner(System.in);

        DivisionCalculator divisionCalculator =
                new DivisionCalculator(validator, divisionMathProvider, divisionViewProvider);
        System.out.println("Enter dividend");
        int dividend = in.nextInt();
        System.out.println("Enter divisor");
        int divisor = in.nextInt();
        in.close();
        System.out.println(divisionCalculator.calculate(dividend, divisor));
    }
}
