package com.projectpl.safeapi.errors.exceptions;

public class ImageNotFoundException extends RuntimeException{
    public ImageNotFoundException(String name){
        super("Could not find image " + name);
    }
}
