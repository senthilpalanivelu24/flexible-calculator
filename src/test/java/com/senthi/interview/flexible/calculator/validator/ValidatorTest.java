package com.senthi.interview.flexible.calculator.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorTest {
    Validator validator = new Validator();

    @Test
    public void validateTest() {
        Throwable exception = assertThrows(ArithmeticException.class, () -> {
            validator.validate( 1, null);
        });
        Assertions.assertEquals("Numbers should not be null", exception.getMessage());
    }
}
