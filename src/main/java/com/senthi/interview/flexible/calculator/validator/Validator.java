package com.senthi.interview.flexible.calculator.validator;

public class Validator {

    public void validate(Number a, Number b) {
        if (a == null || b == null) {
            throw new ArithmeticException("Numbers should not be null");
        }
    }
}
