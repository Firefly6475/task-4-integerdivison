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
        String output = buildFirstThreeLines(dividend, divisor, steps.get(0));
        return output.concat(buildLastLines(steps));
    }

    private String buildFirstThreeLines(int dividend, int divisor, DivisionStep step) {
        StringBuilder lineBuilder = new StringBuilder();

        final int result = dividend / divisor;
        final int resultLength = String.valueOf(result).length();
        final int minuendLength = String.valueOf(step.getMinuend()).length();
        final int subtrahendLength = String.valueOf(step.getSubtrahend()).length();
        final int dividendLength = String.valueOf(dividend).length();
        final int leftOffset = minuendLength - subtrahendLength;
        final int amountOfSpaces = dividendLength - subtrahendLength - leftOffset;

        lineBuilder.append(UNDERSCORE_SYMBOL + dividend);
        lineBuilder.append(VERTICAL_BAR_SYMBOL + divisor);
        lineBuilder.append(NEW_LINE_SYMBOL + WHITESPACE_SYMBOL);

        lineBuilder.append(getMultipleSymbols(leftOffset, WHITESPACE_SYMBOL) + step.getSubtrahend());
        lineBuilder.append(getMultipleSymbols(amountOfSpaces, WHITESPACE_SYMBOL) + VERTICAL_BAR_SYMBOL);
        lineBuilder.append(getMultipleSymbols(resultLength, MINUS_SYMBOL) + NEW_LINE_SYMBOL);

        lineBuilder.append(WHITESPACE_SYMBOL + getMultipleSymbols(minuendLength, MINUS_SYMBOL));
        lineBuilder.append(getMultipleSymbols(dividendLength - minuendLength, WHITESPACE_SYMBOL));
        lineBuilder.append(VERTICAL_BAR_SYMBOL + result + NEW_LINE_SYMBOL);

        return lineBuilder.toString();
    }

    private String buildLastLines(List<DivisionStep> steps) {
        StringBuilder lineBuilder = new StringBuilder();

        for (int i = 1; i < steps.size(); i++) {
            DivisionStep step = steps.get(i);

            lineBuilder.append(getMultipleSymbols(step.getOffset() - 1, WHITESPACE_SYMBOL));
            lineBuilder.append(UNDERSCORE_SYMBOL);
            lineBuilder.append(step.getMinuend() + NEW_LINE_SYMBOL);

            lineBuilder.append(getMultipleSymbols(step.getOffset(), WHITESPACE_SYMBOL));
            lineBuilder.append(step.getSubtrahend() + NEW_LINE_SYMBOL);

            lineBuilder.append(getMultipleSymbols(step.getOffset(), WHITESPACE_SYMBOL));
            lineBuilder.append(
                    getMultipleSymbols(String.valueOf(step.getMinuend()).length(), MINUS_SYMBOL));
            lineBuilder.append(NEW_LINE_SYMBOL);
        }
        for (int i = 0; i <= steps.get(steps.size() - 1).getOffset(); i++) {
            lineBuilder.append(WHITESPACE_SYMBOL);
        }
        lineBuilder.append(steps.get(steps.size() - 1).getQuotient());

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
