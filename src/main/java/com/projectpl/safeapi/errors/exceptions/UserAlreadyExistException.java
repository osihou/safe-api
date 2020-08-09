package com.projectpl.safeapi.errors.exceptions;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException(String error){
        super(error);
    }
}
