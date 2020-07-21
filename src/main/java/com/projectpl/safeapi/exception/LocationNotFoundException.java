package com.projectpl.safeapi.exception;

public class LocationNotFoundException extends RuntimeException{
    public LocationNotFoundException(int id){
        super("Could not find location " + id);
    }
}
