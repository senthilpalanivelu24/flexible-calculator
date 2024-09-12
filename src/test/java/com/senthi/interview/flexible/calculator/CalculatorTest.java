package com.senthi.interview.flexible.calculator;

import com.senthi.interview.flexible.calculator.exception.UnSupportedOperationException;
import com.senthi.interview.flexible.calculator.operation.Operation;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static com.senthi.interview.flexible.calculator.operation.Operation.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    Calculator calculator = new Calculator();
    @Test
    public void calculateTest() {
        Assertions.assertEquals(BigInteger.valueOf(3), calculator.calculate(ADD, 1, 2));
        Assertions.assertEquals(BigDecimal.valueOf(3.0), calculator.calculate(ADD, 1, 2.0));
        Assertions.assertEquals(BigDecimal.valueOf(4.1), calculator.calculate(ADD, 1, 3.1));
    }

    @Test
    public void calculateTestNull() {
        calculator.reset();
        Throwable exception = assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(ADD, 1, null);
        });
        Assertions.assertEquals("Numbers should not be null", exception.getMessage());
        exception = assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(ADD, null, 2);
        });
        Assertions.assertEquals("Numbers should not be null", exception.getMessage());
    }

    @Test
    public void calculateTestInValidOperation() {
        calculator.reset();
        Throwable exception = assertThrows(UnSupportedOperationException.class, () -> {
            calculator.calculate(null, 1, null);
        });
        Assertions.assertEquals("Invalid Operation", exception.getMessage());
    }

    @Test
    public void chainedTest() {
        calculator.reset();
        Number a = calculator.calculate(ADD, 1, 2);
        assert new BigInteger(String.valueOf(3)).equals(a);
        calculator.chainCalculate(ADD, 2)
                .chainCalculate(SUBTRACT, 1)
                .chainCalculate(MULTIPLY, 3);
        Assertions.assertEquals(new BigInteger(String.valueOf(12)), calculator.getResult());
    }

    @Test
    public void multipleChainTest() {
        calculator.reset();
        List<Pair<Operation, Number>> pairs = new ArrayList<>();
        pairs.add(new MutablePair<>(ADD, 2));
        pairs.add(new MutablePair<>(SUBTRACT, 1));
        pairs.add(new MutablePair<>(ADD, 3));
        pairs.add(new MutablePair<>(MULTIPLY, 3));
        Assertions.assertEquals(new BigInteger(String.valueOf(12)), calculator.repeatedChainOperation(pairs));
    }
}
