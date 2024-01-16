package com.myblog4.myblog4.exception;

import com.myblog4.myblog4.payload.ErroDetailes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErroDetailes> handleResourceNotFound(
            ResourceNotFoundException e,
            WebRequest webRequest
    ){
        ErroDetailes erroDetailes= new ErroDetailes(
                e.getMessage(),new Date(), webRequest.getDescription(true)
        );
        return new ResponseEntity<>(erroDetailes, HttpStatus.OK);
    }
}
