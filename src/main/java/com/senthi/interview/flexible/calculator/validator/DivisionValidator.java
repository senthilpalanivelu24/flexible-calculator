package com.senthi.interview.flexible.calculator.validator;

public class DivisionValidator extends Validator {
    public void validate(Number a, Number b) {
        super.validate(a, b);
        if (b.longValue() == 0) throw new ArithmeticException("Denominator can't be zero");
    }
}
