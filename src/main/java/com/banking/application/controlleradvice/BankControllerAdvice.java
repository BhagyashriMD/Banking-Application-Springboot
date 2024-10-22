package com.banking.application.controlleradvice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class BankControllerAdvice 

{
	//1st way using annotation
	
	@ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
	@ExceptionHandler(Exception.class)
    public String handleResourceNotFoundException(Exception ex, WebRequest request) {
        String errorMessage = ex.getMessage();
        return errorMessage;
    }

	//2way using response entity
//    public ResponseEntity<?> handleResourceNotFoundException(Exception ex, WebRequest request) {
//        String errorMessage = ex.getMessage();
//        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
//    }
}
