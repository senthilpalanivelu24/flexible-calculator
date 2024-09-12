package com.senthi.interview.flexible.calculator.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivisionValidatorTest {
    Validator validator = new DivisionValidator();

    @Test
    public void validateTest() {
        Throwable exception = assertThrows(ArithmeticException.class, () -> {
            validator.validate( 1, 0);
        });
        Assertions.assertEquals("Denominator can't be zero", exception.getMessage());
    }
}
