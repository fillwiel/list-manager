package com.wielkopolan.listmanager.exception;

/**
 * Exception thrown if list element cannot be moved up
 */
public class NoFormerListElementException extends Exception {

    public NoFormerListElementException() {
        super("There is no former element on the list. Element is already first on the list.");
    }

    public NoFormerListElementException(String message, Throwable cause) {
        super(message, cause);
    }
}
