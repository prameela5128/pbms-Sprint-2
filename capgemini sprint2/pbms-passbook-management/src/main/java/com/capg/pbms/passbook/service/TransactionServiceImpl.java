package com.capg.pbms.passbook.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.capg.pbms.passbook.exception.AccountException;
import com.capg.pbms.passbook.model.AccountManagement;
import com.capg.pbms.passbook.model.Transaction;
import com.capg.pbms.passbook.model.TransactionList;
import com.capg.pbms.passbook.repo.AccountManagementRepo;
import com.capg.pbms.passbook.repo.TransactionRepo;

@Service
public class TransactionServiceImpl implements ITransactionService{

	@Autowired
	AccountManagementRepo accountRepo;
	@Autowired
	TransactionRepo transactionRepo;
	@Autowired
	RestTemplate rt;
  
	public List<Transaction> printTransactions(long accountId) {
	 	Transaction []t= rt.getForObject("http://transaction-management/transactions/allTransactionsById/id/"+accountId,Transaction[].class);
		return Arrays.asList(t);
	 
}
	
	
	public TransactionList getAllTransactions() {
		
		TransactionList t=rt.getForObject("http://transaction-management/transactions/allTransactions", TransactionList.class);
		return t;
	}

	
	public Transaction getTransactionById(long accountId) {
		Transaction transaction=rt.getForObject("http://transaction-management/transactions/getTransById/id/"+accountId, Transaction.class);
		return transaction;
	}
 
	

	public boolean isValidAccountId(long accountId) {
		String str=String.valueOf(accountId);
		if(str.matches("[0-9]{12}")) {
			 
			return true;	
		}
		throw new AccountException("Account No should be in 12 digits");
		//return false;
	}
 	 
	
	 
}
