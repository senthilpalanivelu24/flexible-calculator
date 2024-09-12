package com.senthi.interview.flexible.calculator.operations.impl;

import com.senthi.interview.flexible.calculator.operations.parser.NumberParser;
import com.senthi.interview.flexible.calculator.validator.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AdditionTest {

    Validator validator = new Validator();
    NumberParser numberParser = new NumberParser();
    Addition addition = new Addition(validator, numberParser);
    @Test
    public void addTest() {
        Assertions.assertEquals(BigInteger.valueOf(3), addition.calculate(1, 2));
        Assertions.assertEquals(BigDecimal.valueOf(3.0), addition.calculate(1.0, 2.0));
    }

    @Test
    public void addTestNull() {
        Throwable exception = assertThrows(ArithmeticException.class, () -> {
            addition.calculate( 1, null);
        });
        Assertions.assertEquals("Numbers should not be null", exception.getMessage());
    }
}
