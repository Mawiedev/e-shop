package com.mawie.Eshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WatchNotFoundAdvice
{
    @ResponseBody
    @ExceptionHandler(WatchNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String watchNotFoundHandler(WatchNotFoundException ex)
    {
        return ex.getMessage();
    }
    
}
