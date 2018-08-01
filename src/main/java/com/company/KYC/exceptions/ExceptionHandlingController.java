package com.company.KYC.exceptions;

import java.util.List;

import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
 
@ControllerAdvice
public class ExceptionHandlingController {
 
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorNumber( HttpStatus.NOT_FOUND.value() );
        response.setErrorMessage(ex.getMessage());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> invalidInput(MethodArgumentNotValidException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorNumber( HttpStatus.BAD_REQUEST.value() );
        List<ObjectError> _rawErrors = ex.getBindingResult().getAllErrors();
        response.setErrorMessage(_rawErrors.get(0).getDefaultMessage());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }   
 
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ExceptionResponse> missingParameter(MissingServletRequestParameterException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorNumber( HttpStatus.BAD_REQUEST.value() );
        response.setErrorMessage(ex.getMessage());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(DataAccessResourceFailureException.class)
    public ResponseEntity<ExceptionResponse> resourceAccessFailure(DataAccessResourceFailureException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorNumber( HttpStatus.INTERNAL_SERVER_ERROR.value() );
        response.setErrorMessage(ex.getMessage());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }  
}
