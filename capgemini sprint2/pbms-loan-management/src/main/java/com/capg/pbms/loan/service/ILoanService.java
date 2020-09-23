package com.capg.pbms.loan.service;

import com.capg.pbms.loan.model.Account;
import com.capg.pbms.loan.model.Customer;
import com.capg.pbms.loan.model.LoanRequest;

public interface ILoanService {
	
	public Customer addAccount(Customer account);
	public Customer accountInfo(long accountId);
	public LoanRequest addLoan(long accountId,int creditScore,double loanAmount,LoanRequest loanrequest);
	public LoanRequest getLoanById(long accountId);
}
