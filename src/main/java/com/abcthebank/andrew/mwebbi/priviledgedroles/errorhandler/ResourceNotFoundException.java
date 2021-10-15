package com.abcthebank.andrew.mwebbi.priviledgedroles.errorhandler;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
