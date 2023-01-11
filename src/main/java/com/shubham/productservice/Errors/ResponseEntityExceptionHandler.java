package com.shubham.productservice.Errors;

import com.shubham.productservice.Exception.ProductServiceCustomException;
import com.shubham.productservice.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductAlreadyExsistsException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
   public ErrorMessage productAlreadyExistsHandler(ProductAlreadyExsistsException exception){
ErrorMessage errorMessage=new ErrorMessage(HttpStatus.FOUND,exception.getMessage());
return errorMessage;
    }


    @ExceptionHandler(ProductServiceCustomException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleProductServiceException(ProductServiceCustomException exception){
     //return new ResponseEntity<(new ErrorMessage().builder())
        ErrorMessage errorMessage= new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
        return errorMessage;
    }

}
