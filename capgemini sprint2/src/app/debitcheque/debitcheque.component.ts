import { Component, OnInit } from '@angular/core';
import { BankingInfoService } from '../banking-info.service';
import { Cheque } from '../Cheque';
import { Transaction } from '../Transaction';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-debitcheque',
  templateUrl: './debitcheque.component.html',
  styleUrls: ['./debitcheque.component.css']
})
export class DebitchequeComponent implements OnInit {
  transAccountId:number;
  transAmount:number;
  status:boolean;
  transaction:Transaction;
  
  cheque:Cheque;
  searchaccountId=0;
  constructor(private bankservice:BankingInfoService,private router:ActivatedRoute,private route:Router){ }
  ngOnInit():void{
       this.transaction=new Transaction();
      this.transaction.chequeList=new Cheque();
         
      
    this.router.params.subscribe(param=>{
      this.searchaccountId=param['id'];
      
   
  })
      }
     onClickSubmit(debitcheque){
    this.bankservice.debitcheque(debitcheque.transAccountId,debitcheque.transAmount,this.transaction).subscribe(
      (success)=>{
        console.log(success);
        alert("account Id "+success.transAccountId+" with amount "+success.transAmount+" withdrawn successfully");
      },
      (error)=>{
        alert("Failed to debit Please enter valid details");
      }
    );
  }
  goBack()
  {
        this.route.navigate(['/employee']);
  } 
}