package com.senthi.interview.flexible.calculator.operations.impl;

import com.senthi.interview.flexible.calculator.operations.parser.NumberParser;
import com.senthi.interview.flexible.calculator.validator.Validator;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Base class for all the operations
 */
@Getter
@AllArgsConstructor
public abstract class BaseOperator {
    private Validator validator;
    private NumberParser numberParser;
}
