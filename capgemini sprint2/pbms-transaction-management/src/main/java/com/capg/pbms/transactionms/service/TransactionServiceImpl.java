/*************************************************************************
 -Author                            : Prameela and Rebeca
 -Created/Modified Date             : 28/04/2020
 -Description                       : TranscationServiceImpl implements TransactionService
 						               for Bank Management System
***************************************************************************/

package com.capg.pbms.transactionms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.capg.pbms.transactionms.exception.AccountAlreadyExistException;
import com.capg.pbms.transactionms.exception.AccountNotFoundException;
import com.capg.pbms.transactionms.exception.AmountException;
import com.capg.pbms.transactionms.exception.InsufficientBalanceException;
import com.capg.pbms.transactionms.model.Customer;
import com.capg.pbms.transactionms.model.LoanRequest;
import com.capg.pbms.transactionms.model.Transaction;
import com.capg.pbms.transactionms.repository.ChequeRepo;
import com.capg.pbms.transactionms.repository.CustomerRepo;
import com.capg.pbms.transactionms.repository.TransactionRepo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.transaction.Transactional;

@Service
public class TransactionServiceImpl implements  TransactionService {

	Map<Long,List<Transaction>> data=new HashMap<>();

	@Autowired
	RestTemplate rt;

  	@Autowired
	CustomerRepo customerRepo;
  	
	@Autowired
	TransactionRepo transactionRepo;
	
	@Autowired
	ChequeRepo chequeRepo;
  	
	Random random=new Random();
	

	/*************************************************************************
	 -FunctionName                     : CreditUsingCheque
	 -Input Parameters                 : accountId,amount,transaction
	 -Return Type                      : transaction
	 -Throws				           : AccountNotFoundException
	 -Author				           : Prameela
	 -Creation Date			           : 28/04/2020
	 -Description			           : saving CreditUsingCheque to database
	***************************************************************************/

	@Override
	@Transactional
	public Transaction creditUsingCheque(long accountId,double amount,Transaction transaction) {
	 	 

		if((isValidAccountId(accountId))==false) {
			throw new AccountNotFoundException("Invalid AccountId");
		}
		else if((isValidAmount(amount))==false) {
			throw new AmountException("please Enter the amount with in 100 - 200000");
		}
		  		Customer customer=customerRepo.getOne(accountId);
		double currentBalance=getBalanceById(accountId)+amount;
		 customer.setAccountBalance(currentBalance);
		 customerRepo.save(customer);
			 transaction.setTransClosingBalance(getBalanceById(accountId));
	 		  String transaction_type="Credit Using Cheque";
	 		   transaction.setTransaction_id(Long.parseLong(String.valueOf(Math.abs(new Random().nextLong())).substring(0, 12)));
			  transaction.setTransAccountId(accountId);
			  transaction.setTransOption(transaction_type);
			  transaction.setTransAmount(amount);
			  transaction.setTransDate(LocalDate.now());
			  transaction.getChequeList().setChequeId(Long.parseLong(String.valueOf(Math.abs(new Random().nextLong())).substring(0, 6)));	 
						
			  
			  Transaction list=new Transaction( accountId,transaction.getTransaction_id(),transaction.getTransAmount(),transaction.getTransOption(),transaction.getTransDate(),transaction.getTransChequeId(),transaction.getTransClosingBalance(),transaction.getChequeList());
			  if(!data.containsKey(accountId)){
				  data.put(accountId,new ArrayList<>());
				  data.get(accountId).add(list);
			  }
			  else{
				  data.get(accountId).add(list);
			  }
			  chequeRepo.save(transaction.getChequeList());

		return transactionRepo.save(transaction);

	}

	/*************************************************************************
	 -FunctionName                     : DebitUsingCheque
	 -Input Parameters                 : accountId,amount,transaction
	 -Return Type                      : transaction
	 -Throws				           :  AccountNotFoundException,AmountException,InsufficientBalanceException
	 -Author				           : Prameela
	 -Creation Date			           : 28/04/2020
	 -Description			           : saving DebitUsingCheque to database
	***************************************************************************/

	@Override
	@Transactional
	public Transaction debitUsingCheque(long accountId,double amount,Transaction transaction) {
		if((isValidAccountId(accountId))==false) {
			throw new AccountNotFoundException("Invalid AccountId");
		}
		else if((isValidAmount(amount))==false) {
			throw new AmountException("please Enter the amount with in 100 - 200000");
		}
		else if(amount>getBalanceById(accountId)) {
			throw new InsufficientBalanceException("Insufficient balance");
		}
		Customer customer=customerRepo.getOne(accountId);
		double currentBalance=getBalanceById(accountId)-amount;
		 customer.setAccountBalance(currentBalance);
		 customerRepo.save(customer);
		 transaction.setTransClosingBalance(getBalanceById(accountId));
		  String transaction_type="Debit Using Cheque";
		   transaction.setTransaction_id(Long.parseLong(String.valueOf(Math.abs(new Random().nextLong())).substring(0, 12)));
		  transaction.setTransAccountId(accountId);
		  transaction.setTransOption(transaction_type);
		  transaction.setTransAmount(amount);
		  transaction.setTransDate(LocalDate.now());	 
		  transaction.getChequeList().setChequeId(Long.parseLong(String.valueOf(Math.abs(new Random().nextLong())).substring(0, 6)));	 
			
		  Transaction list=new Transaction(accountId,transaction.getTransaction_id(),transaction.getTransAmount(),transaction.getTransOption(),transaction.getTransDate(),transaction.getTransChequeId(),transaction.getTransClosingBalance(),transaction.getChequeList());
		  if(!data.containsKey(accountId)){
			  data.put(accountId,new ArrayList<>());
			  data.get(accountId).add(list);
		  }
		  else{
			  data.get(accountId).add(list);
		  }
		  chequeRepo.save(transaction.getChequeList());
	  
	 
	return transactionRepo.save(transaction);

	}

	public boolean isValidAmount(double amount) {
		
	if(amount<100 || amount>200000) {
		return false;
	}
	return true;
	}
	public boolean isValidAccountId(long accountId) {
		String str=String.valueOf(accountId);
		if(str.matches("[0-9]{12}")) {
		return true;	
		}
		return false;
	}

	public boolean isValidChequeIssueDate(LocalDate chequeIssueDate){
		LocalDate transactionDate=LocalDate.now();
		 Long months=ChronoUnit.MONTHS.between(chequeIssueDate, transactionDate) ;
		if(months<=3){
		return  true;
		}
		 
		return false;
	} 
	


	@Override
	public Transaction getLastTransactionById(long transAccountId){
		return transactionRepo.getOne(transAccountId);
	}
	
	@Override
	public List<Transaction> getAllById(long accountId){
		if(!data.containsKey(accountId)) {
			throw new AccountNotFoundException("account not found");
		}
			return new ArrayList<> (data.get(accountId));
	} 
	
	@Override	
 	public List<Transaction> getAllTransactions(){
		return transactionRepo.findAll();
	}
	  

	
	/////////////////////////////////addAccount//////////////////////////////////////////////////////////
	
	@Override
	@Transactional
	public Customer addAccount(Customer customer) {
		customer.setAccountId(Long.parseLong(String.valueOf(Math.abs(new Random().nextLong())).substring(0, 12)));
		customer.setAccountHolderId(String.valueOf(Math.abs(new Random().nextLong())).substring(0, 12));
		customer.setAccountBranchId("1");
		
		customer.setAccountIntrest(0.0);
		customer.setCustomerId(String.valueOf(Math.abs(new Random().nextLong())).substring(0,4));
		if(customerRepo.existsById(customer.getAccountId()))
		throw new AccountAlreadyExistException("Customer with Id: " +customer.getAccountId()+" is Already Exist");
		 return customerRepo.save(customer);
	  
	}

	  	@Override
	public List<Customer> getAllAccounts(){
		
		return customerRepo.findAll();
	}
	
	 
	
	 
	

	@Override	
	@Transactional
	public double getBalanceById(long accountId) {
		Customer customer=customerRepo.getOne(accountId);
         	if(!customerRepo.existsById(accountId) ) {
				throw new AccountNotFoundException("Account does not exists");
			}
		return customer.getAccountBalance();
		 
	}
	
	 	/*************************************************************************
	 -FunctionName                     : CreditUsingSlip
	 -Input Parameters                 : accountId,amount,transaction
	 -Return Type                      : transaction
	 -Throws				           : AccountNotFoundException
	 -Author				           : Rebeca
	 -Creation Date			           : 28/04/2020
	 -Description			           : saving CreditUsingSlip to database
	***************************************************************************/

	@Override	
	@Transactional
	public Transaction creditUsingSlip(long accountId,double amount,Transaction transaction) {
		if((isValidAccountId(accountId))==false) {
			throw new AccountNotFoundException("Invalid AccountId");
		}
		else if((isValidAmount(amount))==false) {
			throw new AmountException("please Enter the amount with in 100 - 200000");
		}
		Customer customer=customerRepo.getOne(accountId);
		
		double currentBalance=getBalanceById(accountId)+amount;
		 customer.setAccountBalance(currentBalance);
		 customerRepo.save(customer);
		 transaction.setTransClosingBalance(getBalanceById(accountId));
		  String transaction_type="Credit Using Slip";
		   transaction.setTransaction_id(Long.parseLong(String.valueOf(Math.abs(new Random().nextLong())).substring(0, 12)));
		  transaction.setTransAccountId(accountId);
		  transaction.setTransOption(transaction_type);
		  transaction.setTransAmount(amount);
		  transaction.setTransDate(LocalDate.now());	 
		  
		  Transaction list=new Transaction( accountId,transaction.getTransaction_id(),transaction.getTransAmount(),transaction.getTransOption(),transaction.getTransDate(),0,transaction.getTransClosingBalance(),null);
		  if(!data.containsKey(accountId)){
			  data.put(accountId,new ArrayList<>());
			  data.get(accountId).add(list);
		  }
		  else{
			  data.get(accountId).add(list);
		  }
		  
	 
	return transactionRepo.save(transaction);
	 
	 }

	/*************************************************************************
	 -FunctionName                     : DebitUsingSlip
	 -Input Parameters                 : accountId,amount,transaction
	 -Return Type                      : transaction
	 -Throws				           : AccountNotFoundException,AmountException,InsufficientBalanceException
	 -Author				           : Rebeca
	 -Creation Date			           : 28/04/2020
	 -Description			           : saving DebitUsingSlip to database
	***************************************************************************/

	@Override
	@Transactional
	public Transaction debitUsingSlip(long accountId,double amount,Transaction transaction) {
		if((isValidAccountId(accountId))==false) {
			throw new AccountNotFoundException("Invalid AccountId");
		}
		else if((isValidAmount(amount))==false) {
			throw new AmountException("please Enter the amount with in 100 - 200000");
		}
		else if(amount>getBalanceById(accountId)) {
			throw new InsufficientBalanceException("Insufficient balance");
		}
  		Customer customer=customerRepo.getOne(accountId);
		
		double currentBalance=getBalanceById(accountId)-amount;
		 customer.setAccountBalance(currentBalance);
		 customerRepo.save(customer);
		 
		 transaction.setTransClosingBalance(getBalanceById(accountId));
		  String transaction_type="Debit Using Slip";
		   transaction.setTransaction_id(Long.parseLong(String.valueOf(Math.abs(new Random().nextLong())).substring(0, 12)));
		  transaction.setTransAccountId(accountId);
		  transaction.setTransOption(transaction_type);
		  transaction.setTransAmount(amount);
		  transaction.setTransDate(LocalDate.now());	 
		  transactionRepo.save(transaction);
		  Transaction list=new Transaction( accountId,transaction.getTransaction_id(),transaction.getTransAmount(),transaction.getTransOption(),transaction.getTransDate(),0,transaction.getTransClosingBalance(),null);
		  if(!data.containsKey(accountId)){
			  data.put(accountId,new ArrayList<>());
			  data.get(accountId).add(list);
		  }
		  else{
			  data.get(accountId).add(list);
		  }
		  
	 
	return transactionRepo.save(transaction);

	}
 }
