package com.capg.pbms.passbook.model;

import java.util.List;

public class TransactionList {
	private List<Transaction> transactionList;
	public TransactionList() {
		
	}
	public TransactionList(List<Transaction> transactionList) {
		super();
		this.transactionList = transactionList;
	}
	public List<Transaction> getTransactionList() {
		return transactionList;
	}
	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}
	
	
}
