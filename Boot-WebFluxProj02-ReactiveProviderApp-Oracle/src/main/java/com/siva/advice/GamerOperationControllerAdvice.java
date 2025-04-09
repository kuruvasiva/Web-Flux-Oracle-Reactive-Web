package com.siva.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GamerOperationControllerAdvice {

	@ExceptionHandler(exception =  RuntimeException.class)
     public ResponseEntity<String> handleRuntimeException(RuntimeException re){
		System.out.println("GamerOperationControllerAdvice.handleRuntimeException() \033[1;34m"+re.getMessage()+"\033[1;0m");
		return new ResponseEntity<>("Runtime Exception Internal Server"+re.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    	 
     }
	@ExceptionHandler(exception = Exception.class)
    public ResponseEntity<String> handleAllException(Exception e){
		System.out.println("GamerOperationControllerAdvice.handleAllException() \033[1;34m"+e.getMessage()+"\033[1;0m");
		return new ResponseEntity<>("Exception Internal Server"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
   	 
    }
	
}
