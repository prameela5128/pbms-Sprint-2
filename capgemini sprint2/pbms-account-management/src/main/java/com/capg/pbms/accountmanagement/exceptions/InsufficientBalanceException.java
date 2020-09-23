package com.capg.pbms.accountmanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Insufficient Balance", value = HttpStatus.NOT_FOUND)
public class InsufficientBalanceException extends RuntimeException{
	
	public InsufficientBalanceException(String message) 
	{
		
		super(message);
	}

}
