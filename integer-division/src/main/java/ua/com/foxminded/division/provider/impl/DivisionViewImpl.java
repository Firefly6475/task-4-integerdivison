package ua.com.foxminded.division.provider.impl;

import java.util.List;
import ua.com.foxminded.division.domain.DivisionStep;
import ua.com.foxminded.division.provider.DivisionViewProvider;

public class DivisionViewImpl implements DivisionViewProvider {
    private static final String MINUS_SYMBOL = "-";
    private static final String NEW_LINE_SYMBOL = "\n";
    private static final String VERTICAL_BAR_SYMBOL = "|";
    private static final String WHITESPACE_SYMBOL = " ";
    private static final String UNDERSCORE_SYMBOL = "_";

    @Override
    public String provideView(int dividend, int divisor, List<DivisionStep> steps) {
        if (steps.isEmpty()) {
            return buildOnlyThreeLines(dividend, divisor);
        }
        String output = buildFirstThreeLines(dividend, divisor, steps.get(0));
        return output.concat(buildLastLines(dividend, steps));
    }
    
    private String buildOnlyThreeLines(int dividend, int divisor) {
        StringBuilder lineBuilder = new StringBuilder();
        final int result = dividend / divisor;
        
        int dividendLength = calculateIntegerLength(dividend);
        int resultLength = calculateIntegerLength(result);
        
        lineBuilder.append(dividend)
                    .append(VERTICAL_BAR_SYMBOL + divisor)
                    .append(NEW_LINE_SYMBOL)
        
                    .append(getMultipleSymbols(dividendLength, WHITESPACE_SYMBOL) + VERTICAL_BAR_SYMBOL)
                    .append(getMultipleSymbols(resultLength, MINUS_SYMBOL) + NEW_LINE_SYMBOL)

                    .append(getMultipleSymbols(dividendLength, WHITESPACE_SYMBOL))
                    .append(VERTICAL_BAR_SYMBOL + result + NEW_LINE_SYMBOL);
        
        return lineBuilder.toString();
    }

    private String buildFirstThreeLines(int dividend, int divisor, DivisionStep step) {
        StringBuilder lineBuilder = new StringBuilder();

        final int result = dividend / divisor;
        final int resultLength = calculateIntegerLength(result);
        final int minuendLength = calculateIntegerLength(step.getMinuend());
        final int subtrahendLength = calculateIntegerLength(step.getSubtrahend());
        final int dividendLength = calculateIntegerLength(dividend);
        final int leftOffset = minuendLength - subtrahendLength;
        final int amountOfSpacesBeforeBar = dividendLength - subtrahendLength - leftOffset;

        lineBuilder.append(UNDERSCORE_SYMBOL + dividend)
                    .append(VERTICAL_BAR_SYMBOL + divisor)
                    .append(NEW_LINE_SYMBOL + WHITESPACE_SYMBOL)

                    .append(getMultipleSymbols(leftOffset, WHITESPACE_SYMBOL) + step.getSubtrahend())
                    .append(getMultipleSymbols(amountOfSpacesBeforeBar, WHITESPACE_SYMBOL) + VERTICAL_BAR_SYMBOL)
                    .append(getMultipleSymbols(resultLength, MINUS_SYMBOL) + NEW_LINE_SYMBOL)
        
                    .append(WHITESPACE_SYMBOL + getMultipleSymbols(minuendLength, MINUS_SYMBOL))
                    .append(getMultipleSymbols(dividendLength - minuendLength, WHITESPACE_SYMBOL))
                    .append(VERTICAL_BAR_SYMBOL + result + NEW_LINE_SYMBOL);

        return lineBuilder.toString();
    }

    private int calculateIntegerLength(final int result) {
        return String.valueOf(result).length();
    }

    private String buildLastLines(int dividend, List<DivisionStep> steps) {
        StringBuilder lineBuilder = new StringBuilder();
        DivisionStep lastStep = steps.get(steps.size() - 1);
        for (int i = 1; i < steps.size(); i++) {
            DivisionStep step = steps.get(i);
            DivisionStep previousStep = steps.get(i - 1);
            int amountOfSpaces = calculateIntegerLength(previousStep.getQuotient());
            int offset = step.getOffset() - 1;
            
            lineBuilder.append(getMultipleSymbols(offset - amountOfSpaces, WHITESPACE_SYMBOL))
                        .append(UNDERSCORE_SYMBOL)
                        .append(step.getMinuend() + NEW_LINE_SYMBOL)

                        .append(getMultipleSymbols(offset - amountOfSpaces + 1, WHITESPACE_SYMBOL))
                        .append(step.getSubtrahend() + NEW_LINE_SYMBOL)

                        .append(getMultipleSymbols(offset - amountOfSpaces + 1, WHITESPACE_SYMBOL))
                        .append(getMultipleSymbols(calculateIntegerLength(step.getMinuend()), MINUS_SYMBOL))
                        .append(NEW_LINE_SYMBOL);
        }
        for (int i = 0; i < calculateIntegerLength(dividend) - calculateIntegerLength(lastStep.getQuotient()) + 1; i++) {
            lineBuilder.append(WHITESPACE_SYMBOL);
        }
        lineBuilder.append(lastStep.getQuotient());

        return lineBuilder.toString();
    }

    private String getMultipleSymbols(int amount, String symbol) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            stringBuilder.append(symbol);
        }

        return stringBuilder.toString();
    }

}
