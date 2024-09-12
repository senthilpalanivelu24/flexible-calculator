package com.senthi.interview.flexible.calculator.operations;

/**
 *
 * Interface for the operations
 *
 */
public interface Calculable {

    /**
     *
     * Calculates the result for the provided 2 input values
     *
     * @param a - value 1
     * @param b - value 2
     * @return - result of the operation on the provided parameters
     */
    Number calculate(Number a, Number b);
}
