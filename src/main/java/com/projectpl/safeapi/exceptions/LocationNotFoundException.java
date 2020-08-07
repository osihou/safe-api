package com.projectpl.safeapi.exceptions;

public class LocationNotFoundException extends RuntimeException{
    public LocationNotFoundException(int id){
        super("Could not find location " + id);
    }
}
