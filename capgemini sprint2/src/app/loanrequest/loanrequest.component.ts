import { Component, OnInit } from '@angular/core';
import { Loanrequest } from '../Loanrequest';
import { BankingInfoService } from '../banking-info.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-loanrequest',
  templateUrl: './loanrequest.component.html',
  styleUrls: ['./loanrequest.component.css']
})
export class LoanrequestComponent implements OnInit {

loanRequestId:number;
loanAmount:number;
creditscore:number;
loanrequest:Loanrequest;
searchaccountId=0;
  constructor(private bankservice:BankingInfoService,private router:ActivatedRoute,private route:Router) { }

  ngOnInit(): void {
    this.loanrequest=new Loanrequest();
    this.router.params.subscribe(param=>{
      this.searchaccountId=param['id'];
      
   
  })
    
  }
  loanStatus():any
{
  if(this.creditscore > 670 && this.creditscore < 999  )
  {
    alert("Loan is approved successfully")
  }
  else
  {
    alert("Loan is rejected");
  }
}
  onClickSubmit(Loanrequest){
    this.bankservice.addLoan(Loanrequest.loanRequestId,Loanrequest.loanAmount,Loanrequest.creditscore,this.loanrequest).subscribe(
      (success)=>{
        console.log(success);
        alert("account Id "+success.loanRequestId+" with amount "+success.loanAmount+" with creditscore"+success.CreditScore+"Loan request accepted");
      },
      (error)=>{
        alert("Loan request Rejected");
      }
    );
  }
  
  goBack()
  {
        this.route.navigate(['/employee']);
  }

}
