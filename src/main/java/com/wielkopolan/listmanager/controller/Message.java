package com.wielkopolan.listmanager.controller;

/**
 * Message Enum allows for storing message and style to be used by alert div toast on the main page
 */
public enum Message {
    MOVED_UP("Element moved up", "alert-success"),
    MOVED_DOWN("Element moved down", "alert-success"),
    MOVED_MOVED_TO_TOP("Element moved to the top", "alert-success"),
    MOVED_MOVED_TO_BOTTOM("Element moved to the bottom", "alert-success"),
    ELEMENT_AT_TOP("Element already at the top", "alert-warning"),
    ELEMENT_AT_BOTTOM("Element already at the bottom", "alert-warning");

    /**
     * Status message
     */
    public String messageValue;

    /**
     * HTML class of alert div
     */
    public String alertClass;

    private Message(String messageValue) {
        this.messageValue = messageValue;
    }

    private Message(String messageValue, String alertClass) {
        this.messageValue = messageValue;
        this.alertClass = alertClass;
    }}
