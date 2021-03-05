package ua.com.foxminded.division.provider.impl;

import java.util.ArrayList;
import ua.com.foxminded.division.domain.DivisionStep;
import ua.com.foxminded.division.provider.DivisionMathProvider;

public class DivisionMathImpl implements DivisionMathProvider {
    @Override
    public ArrayList<DivisionStep> provideMathCalculation(int dividend, int divisor) {
        int length = String.valueOf(dividend).length() - 1;
        ArrayList<DivisionStep> steps = new ArrayList<>();
        if (dividend < divisor) {
            return steps;
        }
        boolean isDigitWentDown = false;
        int minuend = calculateMinuend(dividend, length);
        int offset = 0;
        if (minuend < divisor) {
            length--;
            offset++;
        }
        while (length >= 0) {
            if (minuend >= divisor) {
                int subtrahend = divisor * (minuend / divisor);
                int quotient = minuend - subtrahend;
                steps.add(DivisionStep.builder().withMinuend(minuend).withSubtrahend(subtrahend)
                        .withQuotient(quotient).withOffset(offset).build());
                minuend = quotient;
                isDigitWentDown = false;
                offset++;
                length--;
            } else {
                if (isDigitWentDown) {
                    length--;
                    offset++;
                }
                int digitFromDividend = calculateMinuend(dividend, length) % 10;
                minuend = minuend * 10 + digitFromDividend;
                isDigitWentDown = true;
            }
        }
        return steps;
    }

    private int calculateMinuend(int dividend, int length) {
        return dividend / (int) Math.pow(10, length);
    }
}
