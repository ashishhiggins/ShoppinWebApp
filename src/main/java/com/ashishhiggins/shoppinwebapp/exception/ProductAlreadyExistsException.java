package com.ashishhiggins.shoppinwebapp.exception;

public class ProductAlreadyExistsException extends RuntimeException{

    public ProductAlreadyExistsException(String resourceName, String fieldName, String fieldValue) {

        super(String.format("%s already Exists with the given ProductID  %s : '%s'", resourceName, fieldName, fieldValue));
    }
}
