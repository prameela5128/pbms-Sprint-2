import { Component, OnInit } from '@angular/core';
import { BankingInfoService } from '../banking-info.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Transaction } from '../Transaction';
import { Customer } from '../Customer';

@Component({
  selector: 'app-veiw-transactions',
  templateUrl: './veiw-transactions.component.html',
  styleUrls: ['./veiw-transactions.component.css']
})
export class VeiwTransactionsComponent implements OnInit {

  constructor(private bankingInfoService:BankingInfoService,private router:ActivatedRoute,private route:Router) { }
  searchaccountId=0;
  transaction:Array<Transaction>;
  customer:Customer;
    ngOnInit(): void {
      this.router.params.subscribe(param=>{
        this.searchaccountId=param['id'];
         alert("View Compoment "+this.searchaccountId);
  
      
    });
    this.bankingInfoService.listAllTransactionsById(this.searchaccountId).subscribe(
      (response)=>{
        this.transaction=response;
        console.log(this.transaction);
        
      },
      (error)=>{
alert("no transactions have been done for account"+this.searchaccountId)
      }
      ); 
  

    }
    goBack()
    {
          this.route.navigate(['/employee']);
    } 
  
  }