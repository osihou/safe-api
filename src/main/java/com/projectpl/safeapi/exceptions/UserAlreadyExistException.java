package com.projectpl.safeapi.exceptions;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException(String error){
        super(error);
    }
}
