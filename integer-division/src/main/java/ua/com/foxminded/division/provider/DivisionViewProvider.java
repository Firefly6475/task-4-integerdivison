package ua.com.foxminded.division.provider;

import java.util.List;
import ua.com.foxminded.division.domain.DivisionStep;

public interface DivisionViewProvider {
    String provideView(int dividend, int divisor, List<DivisionStep> steps);
}
