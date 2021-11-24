package com.lab.Exception;

public class RequestParameterException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public RequestParameterException(String msg) {
        super(msg);
    }

}
