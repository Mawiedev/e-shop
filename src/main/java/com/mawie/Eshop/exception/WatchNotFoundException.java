package com.mawie.Eshop.exception;


public class WatchNotFoundException extends RuntimeException
{
    public WatchNotFoundException( long id )
    {
        super("Could not find watch "+ id);
    }

}
