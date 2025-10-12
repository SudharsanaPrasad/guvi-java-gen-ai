package com.guvi.exceptions.activity;

public class InvalidPinException extends RuntimeException {
    public InvalidPinException(String msg) {
        super(msg);
    }
}

