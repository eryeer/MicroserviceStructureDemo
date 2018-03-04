package com.wxbc.exception;

public class HystrixFallBackException extends Exception {
    public HystrixFallBackException(String msg) {
        super(msg);
    }
}
