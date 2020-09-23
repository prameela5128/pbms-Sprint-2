import { Component, OnInit } from '@angular/core';
import { Customer } from '../Customer';
import { BankingInfoService } from '../banking-info.service';
import { Address } from '../address';
import {Transaction} from '../transaction';
import { Cheque } from '../Cheque';
import { ActivatedRoute, Router } from '@angular/router';
import { Route } from '@angular/compiler/src/core';

 @Component({
  selector: 'app-creditslip',
  templateUrl: './creditslip.component.html',
  styleUrls: ['./creditslip.component.css']
})
export class CreditslipComponent implements OnInit {
  transAccountId:number;
  transAmount:number;
  status:boolean;
  transaction:Transaction;
  
  //cheque:Cheque;
  searchaccountId=0;
  constructor(private bankservice:BankingInfoService,private router:ActivatedRoute,private route:Router){ }
  ngOnInit():void{
       this.transaction=new Transaction();
     //this.transaction.chequeList=new Cheque();
         
      
    this.router.params.subscribe(param=>{
      this.searchaccountId=param['id'];
      
   
  })
    // this.bankservice.listallcustomers().subscribe(
    //   (data)=>{
    //     this.customerlist=data.customerlist;
    //     console.log(this.customerlist);
    //   }
    // )
  }
  // onclickSubmit(transAccountId,transAmount){
  //   console.log(this.transAccountId,this.transAmount);
  //   this.transAccountId=transAccountId;
  //   this.transAmount=transAmount
  //   this.status=true;
  // }
  // creditcheque(transaction){
    onClickSubmit(creditslip){
    this.bankservice.creditslip(creditslip.transAccountId,creditslip.transAmount,this.transaction).subscribe(
      (success)=>{
        console.log(success);
        alert("account Id "+success.transAccountId+" with amount "+success.transAmount+" credited successfully");
      },
      (error)=>{
        alert("failed to credit Please enter valid details..");
      }
    );
  }
  
  goBack()
  {
        this.route.navigate(['/employee']);
  }
}
