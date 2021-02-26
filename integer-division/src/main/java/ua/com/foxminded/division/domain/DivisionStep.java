package ua.com.foxminded.division.domain;

public class DivisionStep {
    private final int minuend;
    private final int subtrahend;
    private final int quotient;
    private final int offset;

    public DivisionStep(int minuend, int subtrahend, int quotient, int offset) {
        this.minuend = minuend;
        this.subtrahend = subtrahend;
        this.quotient = quotient;
        this.offset = offset;
    }

    public int getMinuend() {
        return minuend;
    }

    public int getSubtrahend() {
        return subtrahend;
    }

    public int getQuotient() {
        return quotient;
    }

    public int getOffset() {
        return offset;
    }


}
