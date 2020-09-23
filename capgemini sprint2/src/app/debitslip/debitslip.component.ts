import { Component, OnInit } from '@angular/core';
import { Transaction } from '../Transaction';
import { Cheque } from '../Cheque';
import { BankingInfoService } from '../banking-info.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-debitslip',
  templateUrl: './debitslip.component.html',
  styleUrls: ['./debitslip.component.css']
})
export class DebitslipComponent implements OnInit {
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
     
  }
   
    onclickSubmit(debitslip){
    this.bankservice.debitslip(debitslip.transAccountId,debitslip.transAmount,this.transaction).subscribe(
      (success)=>{
        console.log(success);
        alert("account Id "+success.transAccountId+" with amount "+success.transAmount+" withdrawn successfully");
      },
      (error)=>{
        alert("failed to debit Please enter valid details");
      }
    );
  }
  goBack()
  {
        this.route.navigate(['/employee']);
  }  
}
