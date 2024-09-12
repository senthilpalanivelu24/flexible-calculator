package com.senthi.interview.flexible.calculator.operations.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberParserTest {

    NumberParser numberParser = new NumberParser();

    @Test
    public void getResultTest() {
        Assertions.assertEquals(BigInteger.valueOf(3), numberParser.getResult(BigDecimal.valueOf(3.0), 1, 2));
        Assertions.assertEquals(BigDecimal.valueOf(3.0), numberParser.getResult(BigDecimal.valueOf(3.0), 1, 2.0));

    }
}
