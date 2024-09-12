package com.senthi.interview.flexible.calculator.operations.impl;

import com.senthi.interview.flexible.calculator.validator.DivisionValidator;
import com.senthi.interview.flexible.calculator.operations.parser.NumberParser;
import com.senthi.interview.flexible.calculator.validator.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivisionTest {

    Validator validator = new DivisionValidator();
    NumberParser numberParser = new NumberParser();
    Division division = new Division(validator, numberParser);
    @Test
    public void multiplyTest() {
        Assertions.assertEquals(BigDecimal.valueOf(0.5), division.calculate(1, 2));
        Assertions.assertEquals(BigInteger.valueOf(1), division.calculate(1, 1));
    }

    @Test
    public void multiplyTestNull() {
        Throwable exception = assertThrows(ArithmeticException.class, () -> {
            division.calculate( 1, null);
        });
        Assertions.assertEquals("Numbers should not be null", exception.getMessage());
    }

    @Test
    public void multiplyTestZeroValue() {
        Throwable exception = assertThrows(ArithmeticException.class, () -> {
            division.calculate(1, 0.0);
        });
        Assertions.assertEquals("Denominator can't be zero", exception.getMessage());
    }

}
