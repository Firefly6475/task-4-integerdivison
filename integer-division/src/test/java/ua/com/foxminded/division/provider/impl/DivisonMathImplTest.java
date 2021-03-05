package ua.com.foxminded.division.provider.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.division.domain.DivisionStep;
import ua.com.foxminded.division.provider.DivisionMathProvider;

public class DivisonMathImplTest {
    private final DivisionMathProvider divisionMathProvider = new DivisionMathImpl();

    @Test
    void provideMathCalculationShouldReturnStepsIfFirstDividendDigitCanBeDivided() {
        List<DivisionStep> expectedSteps = new ArrayList<>();
        List<DivisionStep> actualSteps = divisionMathProvider.provideMathCalculation(78945, 4);

        expectedSteps.add(DivisionStep.builder().withMinuend(7).withSubtrahend(4).withQuotient(3)
                .withOffset(0).build());
        expectedSteps.add(DivisionStep.builder().withMinuend(38).withSubtrahend(36).withQuotient(2)
                .withOffset(1).build());
        expectedSteps.add(DivisionStep.builder().withMinuend(29).withSubtrahend(28).withQuotient(1)
                .withOffset(2).build());
        expectedSteps.add(DivisionStep.builder().withMinuend(14).withSubtrahend(12).withQuotient(2)
                .withOffset(3).build());
        expectedSteps.add(DivisionStep.builder().withMinuend(25).withSubtrahend(24).withQuotient(1)
                .withOffset(4).build());

        assertEquals(expectedSteps, actualSteps);
    }

    @Test
    void provideMathCalculationShouldReturnStepsIfFirstDividendDigitCantBeDivided() {
        List<DivisionStep> expectedSteps = new ArrayList<>();
        List<DivisionStep> actualSteps = divisionMathProvider.provideMathCalculation(1000945, 4);

        expectedSteps.add(DivisionStep.builder().withMinuend(10).withSubtrahend(8).withQuotient(2)
                .withOffset(1).build());
        expectedSteps.add(DivisionStep.builder().withMinuend(20).withSubtrahend(20).withQuotient(0)
                .withOffset(2).build());
        expectedSteps.add(DivisionStep.builder().withMinuend(9).withSubtrahend(8).withQuotient(1)
                .withOffset(4).build());
        expectedSteps.add(DivisionStep.builder().withMinuend(14).withSubtrahend(12).withQuotient(2)
                .withOffset(5).build());
        expectedSteps.add(DivisionStep.builder().withMinuend(25).withSubtrahend(24).withQuotient(1)
                .withOffset(6).build());

        assertEquals(expectedSteps, actualSteps);
    }

    @Test
    void provideMathCalculationShouldReturnEmptyStepsIfDividendIsZero() {
        List<DivisionStep> expectedSteps = new ArrayList<>();
        List<DivisionStep> actualSteps = divisionMathProvider.provideMathCalculation(0, 10);

        assertEquals(expectedSteps, actualSteps);
    }

    @Test
    void provideMathCalculationShouldReturnStepsIfDividendEqualsDivisor() {
        List<DivisionStep> expectedSteps = new ArrayList<>();
        List<DivisionStep> actualSteps = divisionMathProvider.provideMathCalculation(10, 10);

        expectedSteps.add(DivisionStep.builder().withMinuend(10).withSubtrahend(10).withQuotient(0)
                .withOffset(1).build());

        assertEquals(expectedSteps, actualSteps);
    }

    @Test
    void provideMathCalculationShouldReturnStepsIfDividendMuchGreaterThanDivisor() {
        List<DivisionStep> expectedSteps = new ArrayList<>();
        List<DivisionStep> actualSteps = divisionMathProvider.provideMathCalculation(100008, 5);

        expectedSteps.add(DivisionStep.builder().withMinuend(10).withSubtrahend(10).withQuotient(0)
                .withOffset(1).build());
        expectedSteps.add(DivisionStep.builder().withMinuend(8).withSubtrahend(5).withQuotient(3)
                .withOffset(5).build());

        assertEquals(expectedSteps, actualSteps);
    }

    @Test
    void provideMathCalculationShouldReturnEmptyStepsIfDividendIsLessThanDivisor() {
        List<DivisionStep> expectedSteps = new ArrayList<>();
        List<DivisionStep> actualSteps = divisionMathProvider.provideMathCalculation(5, 8);

        assertEquals(expectedSteps, actualSteps);
    }
}
