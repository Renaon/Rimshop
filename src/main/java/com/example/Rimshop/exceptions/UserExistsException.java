package com.example.Rimshop.exceptions;

public class UserExistsException extends RuntimeException{
    private static final long serialVersionUID = 2L;

    private String msg;

    public UserExistsException(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }
}
