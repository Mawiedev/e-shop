package com.mawie.Eshop.exception;


import org.springframework.validation.Errors;


public class WatchValidationException extends RuntimeException
{
    
    private final Errors errors;

    public Errors getErrors()
    {
        return errors;
    }
    
    public WatchValidationException(Errors errors)
    {
        this.errors = errors;
    }
    
}
