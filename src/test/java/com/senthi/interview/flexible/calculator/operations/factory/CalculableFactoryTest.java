package com.senthi.interview.flexible.calculator.operations.factory;

import com.senthi.interview.flexible.calculator.exception.UnSupportedOperationException;
import com.senthi.interview.flexible.calculator.operation.Operation;
import com.senthi.interview.flexible.calculator.operations.impl.Addition;
import com.senthi.interview.flexible.calculator.operations.impl.Division;
import com.senthi.interview.flexible.calculator.operations.impl.Multiplication;
import com.senthi.interview.flexible.calculator.operations.impl.Subtraction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculableFactoryTest {

    @Test
    public void getInstanceTest() {
        Assertions.assertEquals(CalculableFactory.getInstance(Operation.ADD).getClass(), Addition.class);
        Assertions.assertEquals(CalculableFactory.getInstance(Operation.SUBTRACT).getClass(), Subtraction.class);
        Assertions.assertEquals(CalculableFactory.getInstance(Operation.MULTIPLY).getClass(), Multiplication.class);
        Assertions.assertEquals(CalculableFactory.getInstance(Operation.DIVIDE).getClass(), Division.class);
    }

    @Test
    public void getInstanceTestInvalid() {
        Throwable exception = assertThrows(UnSupportedOperationException.class, () -> {
            CalculableFactory.getInstance(null);
        });
        Assertions.assertEquals("Invalid Operation", exception.getMessage());
    }
}
