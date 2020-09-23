package com.capg.pbms.passbook.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="cheque_info")
public class Cheque {
	 
	@Id 
//	@Pattern(regexp="[0-9]{6}")
	private long chequeId;
	//@Pattern(regexp="[0-9]{12}")
	private long chequeAccountNo;
	private String chequeHolderName;
	private String chequeBankName;
//	@NotEmpty(message="it must contain alpha numeric numbers")
//	@NotBlank(message="cheque IFSC can not be blank")
	//@Pattern(regexp="^[a-zA-Z0-9]{10}")
	private String chequeIFSC;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate chequeIssueDate;
 	 
	@OneToOne
	@JoinColumn(name="trans_account_id")
	private Transaction transaction;
	
 	 
	
	public Cheque() {
	super();	
	}



	public long getChequeId() {
		return chequeId;
	}



	public void setChequeId(long chequeId) {
		this.chequeId = chequeId;
	}



	public long getChequeAccountNo() {
		return chequeAccountNo;
	}



	public void setChequeAccountNo(long chequeAccountNo) {
		this.chequeAccountNo = chequeAccountNo;
	}



	public String getChequeHolderName() {
		return chequeHolderName;
	}



	public void setChequeHolderName(String chequeHolderName) {
		this.chequeHolderName = chequeHolderName;
	}



	public String getChequeBankName() {
		return chequeBankName;
	}



	public void setChequeBankName(String chequeBankName) {
		this.chequeBankName = chequeBankName;
	}



	public String getChequeIFSC() {
		return chequeIFSC;
	}



	public void setChequeIFSC(String chequeIFSC) {
		this.chequeIFSC = chequeIFSC;
	}



	public LocalDate getChequeIssueDate() {
		return chequeIssueDate;
	}



	public void setChequeIssueDate(LocalDate chequeIssueDate) {
		this.chequeIssueDate = chequeIssueDate;
	}



	public Transaction getTransaction() {
		return transaction;
	}



	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}



	public Cheque(long chequeId, long chequeAccountNo, String chequeHolderName, String chequeBankName,
			String chequeIFSC, LocalDate chequeIssueDate) {
		super();
		this.chequeId = chequeId;
		this.chequeAccountNo = chequeAccountNo;
		this.chequeHolderName = chequeHolderName;
		this.chequeBankName = chequeBankName;
		this.chequeIFSC = chequeIFSC;
		this.chequeIssueDate = chequeIssueDate;
	}



	@Override
	public String toString() {
		return "Cheque [chequeId=" + chequeId + ", chequeAccountNo=" + chequeAccountNo + ", chequeHolderName="
				+ chequeHolderName + ", chequeBankName=" + chequeBankName + ", chequeIFSC=" + chequeIFSC
				+ ", chequeIssueDate=" + chequeIssueDate + "]";
	}
	
 }
