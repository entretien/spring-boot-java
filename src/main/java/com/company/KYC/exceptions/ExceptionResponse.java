package com.company.KYC.exceptions;


public class ExceptionResponse {
	 
    private int errorNumber;
    private String errorMessage;
 
    public ExceptionResponse() {
    }
 
    public int getErrorNumber() {
        return errorNumber;
    }
 
    public void setErrorNumber(int errorNumber) {
        this.errorNumber = errorNumber;
    }
 
    public String getErrorMessage() {
        return errorMessage;
    }
 
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    
}
