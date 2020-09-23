import { Component, OnInit } from '@angular/core';
import { BankingInfoService } from '../banking-info.service';
import { Employee } from '../Employee';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private bankingInfoService:BankingInfoService,private route:Router) { }
employee:Employee;
  ngOnInit(): void {
  }
  onClickSubmit(form)
  {
    this.bankingInfoService.validateEmployee(form.employeeName,form.employeePassword).subscribe(
       (success)=>{
         alert(success.employeeName+" Logined Successfully");
           this.route.navigate(['/employee']) ; 
       },
       (error)=>{
          alert("Invalid UserName or Password");
       }

    )
  }

}
