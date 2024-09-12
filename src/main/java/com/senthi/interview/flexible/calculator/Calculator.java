package com.senthi.interview.flexible.calculator;

import com.senthi.interview.flexible.calculator.operation.Operation;
import com.senthi.interview.flexible.calculator.operations.factory.CalculableFactory;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Optional;

public class Calculator {
    private Number result = 0;

    public Number calculate(Operation operation, Number a, Number b) {
        result =  CalculableFactory.getInstance(operation).calculate(a, b);
        return result;
    }

    public Calculator chainCalculate(Operation operation, Number a) {
        result = CalculableFactory.getInstance(operation).calculate(result, a);
        return this;
    }

    public void reset() {
        result = 0;
    }

    public Number getResult() {
        return result;
    }

    public Number repeatedChainOperation(List<Pair<Operation, Number>> operations) {
        Pair<Operation, Number> pair = new MutablePair<>(null, result);
        Pair<Operation, Number> computedResult = operations.stream()
                .reduce(pair, (partialResult, e) ->
                        new MutablePair<>(e.getKey(), calculate(e.getKey(), partialResult.getValue(), e.getValue())));
        result = computedResult.getValue();
        return result;
    }

}
