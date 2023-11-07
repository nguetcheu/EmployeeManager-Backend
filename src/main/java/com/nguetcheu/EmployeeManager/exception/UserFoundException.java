package com.nguetcheu.EmployeeManager.exception;

public class UserFoundException extends RuntimeException {
    public UserFoundException(String message){
        super(message);
    }
}
