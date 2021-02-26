package ua.com.foxminded.division.provider.impl;

import java.util.ArrayList;
import ua.com.foxminded.division.domain.DivisionStep;
import ua.com.foxminded.division.provider.DivisionMathProvider;

public class DivisionMathService implements DivisionMathProvider {
    @Override
    public ArrayList<DivisionStep> provideMathCalculation(int dividend, int divisor) {
        int length = String.valueOf(dividend).length() - 1;
        ArrayList<DivisionStep> steps = new ArrayList<>();
        boolean isDigitWentDown = false;
        int minuend = dividend / (int) Math.pow(10, length);
        int offset = 0;
        if (minuend < divisor) {
            length--;
            offset++;
        }
        while (length >= 0) {
            if (minuend >= divisor) {
                int subtrahend = divisor * (minuend / divisor);
                int quotient = minuend - subtrahend;
                steps.add(new DivisionStep(minuend, subtrahend, quotient, offset));
                minuend = quotient;
                isDigitWentDown = false;
                offset++;
                length--;
            } else {
                if (isDigitWentDown) {
                    length--;
                    offset++;
                }
                int digitFromDividend = dividend / (int) Math.pow(10, length) % 10;
                minuend = minuend * 10 + digitFromDividend;
                isDigitWentDown = true;
            }
        }
        return steps;
    }
}
