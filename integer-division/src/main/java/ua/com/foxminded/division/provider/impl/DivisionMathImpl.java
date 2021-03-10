package ua.com.foxminded.division.provider.impl;

import java.util.ArrayList;
import ua.com.foxminded.division.domain.DivisionStep;
import ua.com.foxminded.division.provider.DivisionMathProvider;

public class DivisionMathImpl implements DivisionMathProvider {
    @Override
    public ArrayList<DivisionStep> provideMathCalculation(int dividend, int divisor) {
        if (!isIntegerCanBeDivided(dividend, divisor)) {
            return new ArrayList<>();
        }

        return calculateSteps(dividend, divisor);
    }
    
    private ArrayList<DivisionStep> calculateSteps(int dividend, int divisor) {
        ArrayList<DivisionStep> steps = new ArrayList<>();
        boolean isDigitWentDown = false;
        boolean isMinuendZero = false;
        int length = calculateIntegerLength(dividend);
        int minuend = calculateMinuend(dividend, length);
        int offset = 1;
        if (minuend < divisor) {
            offset++;
            length--;
        }
        while (length >= 0) {
            if (isIntegerCanBeDivided(minuend, divisor)) {
                steps.add(getStep(minuend, divisor, offset));
                minuend = getLastQuotient(steps);
                offset = changeOffset(offset, minuend, isMinuendZero);
                isMinuendZero = changeIsMinuendZero(minuend, isMinuendZero);
                isDigitWentDown = false;
                offset++;
                length--;
            } else {
                if (isDigitWentDown) {
                    offset++;
                    length--;   
                }
                int digitFromDividend = calculateMinuend(dividend, length) % 10;
                minuend = minuend * 10 + digitFromDividend;
                isDigitWentDown = true;
            }
        }
        return steps;
    }

    private int calculateIntegerLength(int dividend) {
        return String.valueOf(dividend).length() - 1;
    }

    private int calculateMinuend(int dividend, int length) {
        return dividend / (int) Math.pow(10, length);
    }

    private boolean isIntegerCanBeDivided(int number, int divisor) {
        return number >= divisor;
    }

    

    private DivisionStep getStep(int minuend, int divisor, int offset) {
        int subtrahend = getSubtrahend(minuend, divisor);
        int quotient = getQuotient(minuend, subtrahend);
        return (DivisionStep.builder()
                .withMinuend(minuend)
                .withSubtrahend(subtrahend)
                .withQuotient(quotient)
                .withOffset(offset)
                .build());
    }

    private int getSubtrahend(int minuend, int divisor) {
        return divisor * (minuend / divisor);
    }

    private int getQuotient(int minuend, int subtrahend) {
        return minuend - subtrahend;
    }

    private int getLastQuotient(ArrayList<DivisionStep> steps) {
        return steps.get(steps.size() - 1).getQuotient();
    }

    private int changeOffset(int offset, int minuend, boolean isMinuendZero) {
        if (minuend == 0) {
            return offset + 1;
        }
        else if (isMinuendZero) {
            return offset - 1;
        }
        return offset;
    }
    
    private boolean changeIsMinuendZero(int minuend, boolean isMinuendZero) {
        if (minuend == 0) {
            return true;
        }
        else if (isMinuendZero) {
            return false;
        }
        return false;
    }
    
}
