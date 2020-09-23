package com.capg.pbms.loan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.capg.pbms.loan.exception.AccountException;
import com.capg.pbms.loan.model.Account;
import com.capg.pbms.loan.model.Customer;
import com.capg.pbms.loan.model.LoanRequest;
import com.capg.pbms.loan.service.ILoanService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
 
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/loans")
public class LoanController {
	
	@Autowired
	ILoanService service;
	@PostMapping("/addAccount")
	public Customer addAccount(@RequestBody Customer account) {
		return service.addAccount(account);
	}

	@PostMapping("/assign/loan/id/{id}/{creditscore}/{amount}")
	//@HystrixCommand(fallbackMethod="addLoanFallBack")
	public LoanRequest addLoan(@PathVariable("id") long accountId,@PathVariable("creditscore") int creditScore,@PathVariable("amount") double loanAmount,@RequestBody LoanRequest loanrequest)
	{
		 return service.addLoan(accountId, creditScore, loanAmount, loanrequest);		
	}
	public LoanRequest addLoanFallback(@PathVariable("id") long accountId,@PathVariable("creditscore") int creditScore,@PathVariable("amount") double loanAmount,@RequestBody LoanRequest loanrequest)
	{
		LoanRequest l=new LoanRequest( accountId,loanAmount, "house loan", 3, 300.00, "Accepted", 500.00, creditScore);
		return l;
	}
 }