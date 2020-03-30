package org.phantasye.oasis.util.math;

public class AdjustableNumberValue<N extends Number> implements AdjustableNumber<N> {

    private final N value;

    public AdjustableNumberValue(N baseValue) {
        this.value = baseValue;
    }

    public AdjustableNumberValue() {
        this.value = (N) new Integer(0);
    }

    @Override
    public N add(N amount) {
        return null;
    }

    @Override
    public N subtract(N amount) {
        return null;
    }

    @Override
    public N increment() {
        return null;
    }

    @Override
    public N decrement() {
        return null;
    }

    public N getValue() {
        return value;
    }
}
