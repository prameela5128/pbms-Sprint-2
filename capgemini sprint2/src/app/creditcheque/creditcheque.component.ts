import { Component, OnInit } from '@angular/core';
import { BankingInfoService } from '../banking-info.service';
import { Transaction } from '../Transaction';
import { Cheque } from '../Cheque';
import { Customer } from '../Customer';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-creditcheque',
  templateUrl: './creditcheque.component.html',
  styleUrls: ['./creditcheque.component.css']
})
export class CreditchequeComponent implements OnInit {
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
    onclickSubmit(creditcheque){
    this.bankservice.creditcheque(creditcheque.transAccountId,creditcheque.transAmount,this.transaction).subscribe(
      (success)=>{
        console.log(success);
        alert("account Id "+success.transAccountId+" with amount "+success.transAmount+" credited successfully");
      },
      (error)=>{
        alert("Please enter valid details");
      }
    );
  }
  goBack()
  {
        this.route.navigate(['/employee']);
  }
}







































  //   transAccountId:number;
//   transAmount:number;
//   chequeId:number;
//  	chequeAccountNo:number;
//   chequeHolderName:string;
//   chequeBankName:string;
//  	chequeIFSC:string;
// 	chequeIssueDate:Date;
//   searchaccountId=0;
//   constructor(private bankingInfoService:BankingInfoService,private route1:Router,private route:ActivatedRoute) { }
//   customer:Customer;
//   transaction:Transaction;
//   cheque:Cheque
//     ngOnInit(): void {
//       this.route.params.subscribe(param=>{
//         this.searchaccountId=param['id'];
        
     
//     })
//   } 
//   onClickSubmit(creditcheque)
//   {
//     this.bankingInfoService.creditcheque(creditcheque.transAccountId,creditcheque.transAmount,creditcheque.transaction).subscribe(
//        (success)=>{
//          alert(" credited ");
           
//        },
//        (error)=>{
//           alert("Invalid AccountId ");
//        }

//     )
//   }

// }  
  