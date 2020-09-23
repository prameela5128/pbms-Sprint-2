package com.capg.pbms.transactionms.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;


@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "The cheque you are trying to credit is invalid it should be with in 3 months", value = HttpStatus.NOT_FOUND)
public class ChequeBounceException extends RuntimeException{
	
	public ChequeBounceException(String message) 
	{
		
		super(message);
	}

 
}
