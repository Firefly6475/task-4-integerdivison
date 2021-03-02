package ua.com.foxminded.division.provider.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.division.domain.DivisionStep;
import ua.com.foxminded.division.provider.DivisionViewProvider;

public class DivisionViewImplTest {
    final static DivisionViewProvider divisionViewProvider = new DivisionViewImpl();

    @Test
    void provideViewShouldReturnStringView() {

        String expectedView = "_78945|4\n" + " 4    |-----\n" + " -    |19736\n" + "_38\n" + " 36\n"
                + " --\n" + " _29\n" + "  28\n" + "  --\n" + "  _14\n" + "   12\n" + "   --\n"
                + "   _25\n" + "    24\n" + "    --\n" + "     1";
        List<DivisionStep> steps = new ArrayList<>();

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

        String actualView = divisionViewProvider.provideView(78945, 4, steps);

        assertEquals(expectedView, actualView);
    }
}
