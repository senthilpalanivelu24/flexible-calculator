package com.senthi.interview.flexible.calculator.exception;

/**
 * UnSupportedOperationException is thrown when the operation is not supported
 *
 */
public class UnSupportedOperationException extends RuntimeException {

    public UnSupportedOperationException(String message) {
        super(message);
    }
}
