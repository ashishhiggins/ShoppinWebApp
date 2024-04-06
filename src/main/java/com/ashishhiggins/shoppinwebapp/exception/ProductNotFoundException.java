package com.ashishhiggins.shoppinwebapp.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String resourceName, String fieldName, String fieldValue) {

        super(String.format("%s not found with the given ProductID  %s : '%s'", resourceName, fieldName, fieldValue));
    }


}
