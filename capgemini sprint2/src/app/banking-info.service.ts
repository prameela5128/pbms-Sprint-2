import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from './Customer';
import { Observable } from 'rxjs';
import { Transaction } from './Transaction';
import { Loanrequest } from './Loanrequest';
import { Employee } from './Employee';

@Injectable({
  providedIn: 'root'
})
export class BankingInfoService {

  constructor(private http:HttpClient) { }

  baseUrl:string="http://localhost:8500/accounts/";

  // public addUser(employee:Employee):Observable<Employee>
  // {
  //   console.log(employee);
  //   console.log(this.baseUrl+"addemployee");
    
  //   return this.http.post<Employee>(this.baseUrl+"addemployee",employee);
  // }


  public addAccount(customer:Customer):Observable<Customer>
  {
       return this.http.post<Customer>(this.baseUrl+"add",customer);
  }

public getAccount(accountId:number):Observable<Customer>
{
  return this.http.get<Customer>(this.baseUrl+"/id/"+accountId);
}
  public deleteaccount(accountId:number):Observable<Customer>
  {
     console.log(this.baseUrl+"deleteaccount/"+accountId);
     return this.http.delete<Customer>(this.baseUrl+"delete/id/"+accountId);
      
  }
  public updateCustomerName(accountId:number,customer:Customer):Observable<Customer>
  {
    console.log(this.baseUrl+"updateName/id/"+accountId);
    console.log(customer);
    
    return this.http.put<Customer>(this.baseUrl+"updateName/id/"+accountId,customer);
  }
  public updateCustomerContact(accountId:number,customer:Customer):Observable<Customer>
  {
    console.log(this.baseUrl+"updateContact/id/"+accountId);
    console.log(customer);
   
    return this.http.put<Customer>(this.baseUrl+"updateContact/id/"+accountId,customer);
  }
  public updateCustomerAddress(accountId:number,customer:Customer):Observable<Customer>
  {
    console.log(this.baseUrl+"updateAddress/id/"+accountId);
    console.log(customer);
   
    return this.http.put<Customer>(this.baseUrl+"updateAddress/id/"+accountId,customer);
  }	
   public listallcustomers()
  {
    console.log(this.baseUrl+"all");
  }

  public creditcheque(accountId:number,amount:number,transaction:Transaction):Observable<Transaction>
  {
    console.log(this.baseUrl+"creditUsingCheque/id/"+accountId+"/amount/"+amount);
    console.log(transaction);
    
     
    return this.http.post<Transaction>(this.baseUrl+"creditUsingCheque/id/"+accountId+"/amount/"+amount,transaction);
  }
 
  public creditslip(accountId:number,amount:number,transaction:Transaction):Observable<Transaction>
  {
    console.log(this.baseUrl+"creditUsingSlip/id/"+accountId+"/amount/"+amount);
    console.log(transaction);
   
    return this.http.post<Transaction>(this.baseUrl+"creditUsingSlip/id/"+accountId+"/amount/"+amount,transaction);
  }
  public debitslip(accountId:number,amount:number,transaction:Transaction):Observable<Transaction>
  {
    console.log(this.baseUrl+"debitUsingSlip/id/"+accountId+"/amount/"+amount);
    console.log(transaction);
   
    return this.http.post<Transaction>(this.baseUrl+"debitUsingSlip/id/"+accountId+"/amount/"+amount,transaction);
  }
  public debitcheque(accountId:number,amount:number,transaction:Transaction):Observable<Transaction>
  { 
    console.log(this.baseUrl+"debitUsingCheque/id/"+accountId+"/amount/"+amount);
    console.log(transaction);
   
    return this.http.post<Transaction>(this.baseUrl+"debitUsingCheque/id/"+accountId+"/amount/"+amount,transaction);
  }

 public addLoan(accountId:number ,creditscore:number,amount:number,loanrequest:Loanrequest):Observable<Loanrequest>
  {
    console.log(this.baseUrl+"requestLoan/id/"+accountId+"/creditScore"+creditscore+"/amount"+amount);
    console.log(loanrequest);
  return this.http.post<Loanrequest>(this.baseUrl+"requestLoan/"+accountId,creditscore+"/creditScore"+creditscore+"/amount"+amount);
  }
  public getbalancebyid(accountId:number):Observable<Customer>
  {
    return this.http.get<Customer>("http://localhost:8500/accounts/getBalanceById/id/"+accountId);
  }
 public listAllTransactionsById(accountId:number):Observable<Array<Transaction>>
 {
   console.log("http://localhost:8500/accounts/allTransactionsById/id/"+accountId);
    
  return this.http.get<Array<Transaction>>("http://localhost:8500/accounts/allTransactionsById/id/"+accountId);
  
 }
 public printpassbook(accountId:number):Observable<Transaction>
 {
  return this.http.get<Transaction>("http://localhost:8500/accounts/printpassbook/id/"+accountId);
  
 }
 public validateEmployee(employeeName:string,employeePassword:string):Observable<Employee>
  {
    console.log("http://localhost:8500/login/"+employeeName+"/"+employeePassword);
    
       return this.http.get<Employee>("http://localhost:8500/login/"+employeeName+"/"+employeePassword);
  }

 
}
