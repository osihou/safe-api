package com.projectpl.safeapi.errors.exceptions;

public class LocationNotFoundException extends RuntimeException{
    public LocationNotFoundException(int id){
        super("Could not find location " + id);
    }
}
