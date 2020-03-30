package org.phantasye.oasis.util.math;

public interface AdjustableNumber<N extends Number> {

    N add(N amount);

    N subtract(N amount);

    N increment();

    N decrement();

}
