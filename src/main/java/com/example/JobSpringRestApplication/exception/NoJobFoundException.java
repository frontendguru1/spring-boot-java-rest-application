package com.example.JobSpringRestApplication.exception;

public class NoJobFoundException extends RuntimeException {
    public NoJobFoundException(String msg) {
        super(msg);
    }
}
