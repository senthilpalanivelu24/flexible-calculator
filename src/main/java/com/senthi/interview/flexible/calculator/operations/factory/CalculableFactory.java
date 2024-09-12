package com.senthi.interview.flexible.calculator.operations.factory;

import com.senthi.interview.flexible.calculator.operation.Operation;
import com.senthi.interview.flexible.calculator.exception.UnSupportedOperationException;
import com.senthi.interview.flexible.calculator.operations.Calculable;
import com.senthi.interview.flexible.calculator.operations.impl.Addition;
import com.senthi.interview.flexible.calculator.operations.impl.Division;
import com.senthi.interview.flexible.calculator.operations.impl.Multiplication;
import com.senthi.interview.flexible.calculator.operations.impl.Subtraction;
import com.senthi.interview.flexible.calculator.validator.DivisionValidator;
import com.senthi.interview.flexible.calculator.operations.parser.NumberParser;
import com.senthi.interview.flexible.calculator.validator.Validator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 *
 *  Factory which helps with returning the instance of the operator and
 *  supports the inversion of control
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CalculableFactory {

    private static final Map<Operation, Calculable> OPERATIONS = Map.of(
            Operation.ADD, new Addition(new Validator(), new NumberParser()),
            Operation.SUBTRACT, new Subtraction(new Validator(), new NumberParser()),
            Operation.MULTIPLY, new Multiplication(new Validator(), new NumberParser()),
            Operation.DIVIDE, new Division(new DivisionValidator(), new NumberParser()));

    /**
     *
     * returns the instance of the operator for the provided operation
     *
     * @param operation - Enum
     * @return the Operator
     */
    public static Calculable getInstance(Operation operation) {
        if (operation == null) {
            throw new UnSupportedOperationException("Invalid Operation");
        }
        return OPERATIONS.get(operation);
    }
}
