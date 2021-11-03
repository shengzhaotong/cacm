package com.lab.Exception;

public class IllegalRequestException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public IllegalRequestException(String msg) {
        super(msg);
    }

}
