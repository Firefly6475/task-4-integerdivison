package ua.com.foxminded.division.domain;

import java.util.Objects;

public class DivisionStep {
    private final int minuend;
    private final int subtrahend;
    private final int quotient;
    private final int offset;

    private DivisionStep(Builder builder) {
        this.minuend = builder.minuend;
        this.subtrahend = builder.subtrahend;
        this.quotient = builder.quotient;
        this.offset = builder.offset;
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

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(DivisionStep divisionStep) {
        return new Builder();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getClass());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        DivisionStep other = (DivisionStep) obj;
        return (Objects.equals(other, obj));
    }

    @Override
    public String toString() {
        return "DivisionStep [minuend=" + minuend + ", subtrahend=" + subtrahend + ", quotient="
                + quotient + ", offset=" + offset + "]";
    }

    public static class Builder {
        private int minuend;
        private int subtrahend;
        private int quotient;
        private int offset;

        private Builder() {

        }

        private Builder(DivisionStep divisionStep) {
            this.minuend = divisionStep.minuend;
            this.subtrahend = divisionStep.subtrahend;
            this.quotient = divisionStep.quotient;
            this.offset = divisionStep.offset;
        }

        public Builder withMinuend(int minuend) {
            this.minuend = minuend;

            return this;
        }

        public Builder withSubtrahend(int subtrahend) {
            this.subtrahend = subtrahend;

            return this;
        }

        public Builder withQuotient(int quotient) {
            this.quotient = quotient;

            return this;
        }

        public Builder withOffset(int offset) {
            this.offset = offset;

            return this;
        }

        public DivisionStep build() {
            return new DivisionStep(this);
        }
    }
}
