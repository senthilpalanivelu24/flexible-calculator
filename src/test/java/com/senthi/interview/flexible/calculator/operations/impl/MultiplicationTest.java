package com.senthi.interview.flexible.calculator.operations.impl;

import com.senthi.interview.flexible.calculator.operations.parser.NumberParser;
import com.senthi.interview.flexible.calculator.validator.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MultiplicationTest {

    Validator validator = new Validator();
    NumberParser numberParser = new NumberParser();
    Multiplication multiplication = new Multiplication(validator, numberParser);

    @Test
    public void multiplyTest() {
        Assertions.assertEquals(BigInteger.valueOf(2), multiplication.calculate(1, 2));
        Assertions.assertEquals(BigInteger.valueOf(0), multiplication.calculate(1, 0));
    }

    @Test
    public void multiplyTestNull() {
        Throwable exception = assertThrows(ArithmeticException.class, () -> {
            multiplication.calculate( 1, null);
        });
        Assertions.assertEquals("Numbers should not be null", exception.getMessage());
    }

}
