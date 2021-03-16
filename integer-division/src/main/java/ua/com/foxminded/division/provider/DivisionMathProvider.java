package ua.com.foxminded.division.provider;

import java.util.ArrayList;
import ua.com.foxminded.division.domain.DivisionStep;

public interface DivisionMathProvider {
    ArrayList<DivisionStep> provideMathCalculation(int dividend, int divisor);
}
