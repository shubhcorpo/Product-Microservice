package com.shubham.productservice.Errors;

public class ProductAlreadyExsistsException extends RuntimeException{
public ProductAlreadyExsistsException(String message){
    super(message);
}
}
