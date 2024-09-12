package com.senthi.interview.flexible.calculator.operations.impl;

import com.senthi.interview.flexible.calculator.operations.parser.NumberParser;
import com.senthi.interview.flexible.calculator.validator.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SubTractionTest {

    Validator validator = new Validator();
    NumberParser numberParser = new NumberParser();
    Subtraction subtraction = new Subtraction(validator, numberParser);

    @Test
    public void subtractionTest() {
        Assertions.assertEquals(BigInteger.valueOf(-1), subtraction.calculate(1, 2));
    }

    @Test
    public void subtractionTestNull() {
        Throwable exception = assertThrows(ArithmeticException.class, () -> {
            subtraction.calculate( 1, null);
        });
        Assertions.assertEquals("Numbers should not be null", exception.getMessage());
    }
}
