package com.lab.Exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;


@RestControllerAdvice
public class WebExceptionControl {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(APIException.class)
    public String APIExceptionHandler(APIException e) {
        logger.error(e.getMessage());
        return "当前用户访问量过大，请稍候重试";
    }

    @ExceptionHandler(JsonProcessingException.class)
    public String JsonExceptionHandler(JsonProcessingException e) {
        logger.error(e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(IOException.class)
    public String IOExceptionHandler(IOException e) {
        logger.error(e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(IPException.class)
    public String IPExceptionHandler(IPException e) {
        logger.error(e.getMessage());
        return "访问次数过于频繁，请稍候在试";
    }

    @ExceptionHandler(IllegalStateException.class)
    public String IllegalStateExceptionHandler(IllegalStateException e) {
        logger.error(e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(IllegalRequestException.class)
    public String IllegalRequestExceptionHandler(IllegalRequestException e) {
        logger.error(e.getMessage());
        return "检测到恶意行为，请求终止";
    }

    @ExceptionHandler(RequestParameterException.class)
    public String RequestParameterExceptionHandler(RequestParameterException e) {
        logger.error(e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(Exception.class)
    public String Exception(Exception e) {
        logger.error(e.getMessage());
        return e.getMessage();
    }

}
