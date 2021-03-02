package ua.com.foxminded.division;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.com.foxminded.division.domain.DivisionStep;
import ua.com.foxminded.division.provider.DivisionMathProvider;
import ua.com.foxminded.division.provider.DivisionViewProvider;
import ua.com.foxminded.division.validator.Validator;

@ExtendWith(MockitoExtension.class)
public class DivisionCalculatorTest {

    @Mock
    private Validator validator;

    @Mock
    private DivisionMathProvider divisionMathProvider;

    @Mock
    private DivisionViewProvider divisionViewProvider;

    @InjectMocks
    private DivisionCalculator divisionCalculator;

    @Test
    void calculateShouldReturnLongDivision() {
        ArrayList<DivisionStep> steps = new ArrayList<>();
        int dividend = 78945;
        int divisor = 4;

        steps.add(DivisionStep.builder().withMinuend(7).withSubtrahend(4).withQuotient(3).withOffset(0)
                .build());
        steps.add(DivisionStep.builder().withMinuend(38).withSubtrahend(36).withQuotient(2)
                .withOffset(1).build());
        steps.add(DivisionStep.builder().withMinuend(29).withSubtrahend(28).withQuotient(1)
                .withOffset(2).build());
        steps.add(DivisionStep.builder().withMinuend(14).withSubtrahend(12).withQuotient(2)
                .withOffset(3).build());
        steps.add(DivisionStep.builder().withMinuend(25).withSubtrahend(24).withQuotient(1)
                .withOffset(4).build());

        String expectedView = "_78945|4\n" + " 4    |-----\n" + " -    |19736\n" + "_38\n" + " 36\n"
                + " --\n" + " _29\n" + "  28\n" + "  --\n" + "  _14\n" + "   12\n" + "   --\n"
                + "   _25\n" + "    24\n" + "    --\n" + "     1";

        doNothing().when(validator).validate(dividend, divisor);
        when(divisionMathProvider.provideMathCalculation(dividend, divisor)).thenReturn(steps);
        when(divisionViewProvider.provideView(dividend, divisor, steps))
                .thenReturn(expectedView);

        String actualView = divisionCalculator.calculate(78945, 4);

        assertEquals(expectedView, actualView);
    }
}
