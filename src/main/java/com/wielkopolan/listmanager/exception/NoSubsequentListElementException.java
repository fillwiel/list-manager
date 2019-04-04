package com.wielkopolan.listmanager.exception;

/**
 * Exception thrown if list element cannot be moved down
 */
public class NoSubsequentListElementException extends Exception {

    public NoSubsequentListElementException() {
        super("There is no subsequent element on the list. Element is already last on the list.");
    }

    public NoSubsequentListElementException(String message, Throwable cause) {
        super(message, cause);
    }
}
