package com.lab.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class WebExceptionControl {

    @ExceptionHandler(APIException.class)
    public String APIExceptionHandler(APIException e) {
        return "当前用户访问量过大，请稍候重试";
    }

    @ExceptionHandler(FileException.class)
    public String FileExceptionHandler(FileException e) {
        if ("未获取到文件输入流".equals(e.getMessage())) {
            return "错误，未找到文件";
        }
        return "服务器发生异常，文件上传失败";
    }

}
