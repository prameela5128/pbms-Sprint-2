package com.capg.pbms.passbook.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capg.pbms.passbook.model.Transaction;
import com.capg.pbms.passbook.model.TransactionList;
import com.capg.pbms.passbook.service.ITransactionService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/passbook")
public class PassbookController {
	@Autowired
	ITransactionService transactionService;
	 
	
	@GetMapping("/allTransactionsById/id/{id}")
	public List<Transaction> printTransactions(@PathVariable("id") long accountId) {
		 	return  transactionService.printTransactions(accountId);
	
	}

	@GetMapping("/lastTransactionById/id/{id}")
	@HystrixCommand(fallbackMethod="getTransactionByIdFallback")
	public Transaction getTransactionById(@PathVariable("id") long accountId) {
		return transactionService.getTransactionById(accountId);
	}

	@GetMapping("/allTransactions")
	public TransactionList getAllTransactions() {
		 
		return transactionService.getAllTransactions();
	}
	public Transaction getTransactionByIdFallback(@PathVariable("id") long accountId) {
		Transaction t=new Transaction(accountId,123456789012L,1000.00, "cheque",LocalDate.now(),123456, 20000.00, null);
		return t;
	}
	
}
