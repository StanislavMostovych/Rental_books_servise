package com.stanislav.exception;

public class DataException extends Exception {
	
	ErrorType errorType;
	String errorMessage;
	
	public ErrorType getErrorType() {
		return errorType;
	}

	public void setErrorType(ErrorType errorType) {
		this.errorType = errorType;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public DataException(ErrorType errorType,  String errorMessage){
		super(errorMessage);
		this.errorType = errorType;
		this.errorMessage = errorMessage;
		
	}
	
	public enum ErrorType{
		BAD_DATA, FOUND, WHATEVER;
	}
}
