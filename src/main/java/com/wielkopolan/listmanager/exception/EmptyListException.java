package com.wielkopolan.listmanager.exception;

import java.util.List;

/**
 * Exception thrown if the list is empty.
 */
public class EmptyListException extends Exception {

    public EmptyListException() {
        super("The list is empty.");
    }

    public EmptyListException(List<Object> list) {
        super("The list " + list.toString() + " is empty.");
    }

    public EmptyListException(String message, Throwable cause) {
        super(message, cause);
    }
}
