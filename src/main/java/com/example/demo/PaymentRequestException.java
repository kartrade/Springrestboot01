package com.example.demo;

public class PaymentRequestException extends Exception{
	
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	private static final long serialVersionUID = 1L;

	public PaymentRequestException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public PaymentRequestException() {
		
	}

}
