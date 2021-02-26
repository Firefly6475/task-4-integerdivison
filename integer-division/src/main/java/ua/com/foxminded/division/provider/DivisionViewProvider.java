package ua.com.foxminded.division.provider;

import java.util.List;
import ua.com.foxminded.division.domain.DivisionStep;

public interface DivisionViewProvider {
    String provideView(int divisor, int dividend, List<DivisionStep> steps);
}
