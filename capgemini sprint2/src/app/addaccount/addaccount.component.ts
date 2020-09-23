import { Component, OnInit } from '@angular/core';
import { Customer } from '../Customer';
import { BankingInfoService } from '../banking-info.service';
import { Address } from '../address';

@Component({
  selector: 'app-addaccount',
  templateUrl: './addaccount.component.html',
  styleUrls: ['./addaccount.component.css']
})
export class AddaccountComponent implements OnInit {

  constructor(private bankingInfoService:BankingInfoService) { }
customer:Customer;
address:Address
  ngOnInit(): void {
this.customer=new Customer();
this.customer.customerAddress=new Address()
  } 
  addAccount(){
    console.log(this.customer);
this.bankingInfoService.addAccount(this.customer).subscribe(
 
  (response)=>
      {
        alert("account added successfully");
      },
      (error)=>
      {
        alert("Failed to add account");
      }
);
  }

}
