package com.projectpl.safeapi.errors.exceptions;

public class OpinionNotFoundException extends RuntimeException {
    public OpinionNotFoundException(int id){
        super("Could not find opinion with " + id);
    }
}
