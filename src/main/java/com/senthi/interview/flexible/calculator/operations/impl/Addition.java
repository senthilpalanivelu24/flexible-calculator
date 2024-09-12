package com.senthi.interview.flexible.calculator.operations.impl;

import com.senthi.interview.flexible.calculator.operations.Calculable;
import com.senthi.interview.flexible.calculator.operations.parser.NumberParser;
import com.senthi.interview.flexible.calculator.validator.Validator;

import java.math.BigDecimal;

/**
 * Implementation for the addition operation
 */
public class Addition extends BaseOperator implements Calculable {

    public Addition(Validator validator, NumberParser numberParser) {
        super(validator, numberParser);
    }

    /**
     *
     * Adds the result for the provided 2 input values
     *
     * @param a - value 1
     * @param b - value 2
     * @return - result of the add operation on the provided parameters
     */
    @Override
    public Number calculate(Number a, Number b) {
        getValidator().validate(a, b);
        return getNumberParser().getResult(BigDecimal.valueOf(a.doubleValue() + b.doubleValue()), a, b);
    }
}
