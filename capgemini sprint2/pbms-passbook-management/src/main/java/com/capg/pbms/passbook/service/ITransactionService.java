package com.capg.pbms.passbook.service;


import java.util.List;

import com.capg.pbms.passbook.model.Transaction;
import com.capg.pbms.passbook.model.TransactionList;
 
public interface ITransactionService{

	public TransactionList getAllTransactions();
 
	
	public Transaction getTransactionById(long accountId);
  
	
	public List<Transaction> printTransactions(long accountId);
 	 
	 
}
