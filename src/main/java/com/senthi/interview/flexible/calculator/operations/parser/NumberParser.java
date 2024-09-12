package com.senthi.interview.flexible.calculator.operations.parser;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberParser {

    /**
     *
     * return true if number is a floating number
     *
     * @param number - input
     * @return true or false based on number is a floating number
     */
    private boolean isInputFloatingNumber(Number number) {
        return number.toString().contains(".");
    }
    private boolean isAFloatingNumber(Number number) {
        BigDecimal bigDecimal = getBigDecimal(number);
        BigDecimal decimalValue = bigDecimal.subtract(new BigDecimal(bigDecimal.longValue()));
        return !decimalValue.equals(BigDecimal.valueOf(0.0)) && !decimalValue.equals(BigDecimal.valueOf(0));
    }

    private BigDecimal getBigDecimal(Number number) {
        return number instanceof  BigDecimal ? (BigDecimal) number : new BigDecimal(number.toString());
    }

    /**
     *
     * Returns the correct result after verifying both the input and result and floating point numbers
     *
     * Example
     *  1 + 2 = will result in a {@link BigInteger}
     *  1 + 2.0 will result in a {@link BigDecimal}
     *  1 / 2 will return a {@link BigDecimal}
     *  1 /1 will return a {@link BigInteger}
     *
     * @param result - result to be modified and returned
     * @param a - first input
     * @param b - second input
     * @return either BigDecimal or BigInteger based on numbers [Look above]
     */
    public Number getResult(BigDecimal result, Number a, Number b) {
        if (isAFloatingNumber(result) || isInputFloatingNumber(a) || isInputFloatingNumber(b)) {
            return result;
        } else {
            return BigInteger.valueOf(result.longValue());
        }
    }
}
