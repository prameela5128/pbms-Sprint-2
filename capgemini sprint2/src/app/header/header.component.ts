import { Component, OnInit } from '@angular/core';
import { BankingInfoService } from '../banking-info.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public currentDate:string="";
  public currentTime:string="";
  searchTxt=0;
  constructor(private bankingInfoService:BankingInfoService, private route:Router) { }

  ngOnInit(): void {                                     
    setInterval(()=>{
      this.showDate();
    },1000);   
  }
  showDate()
  {
    this.currentDate=new Date().toDateString();
    this.currentTime=new Date().toLocaleTimeString();
  }
searchTransaction(){
  
this.route.navigate(["/view-transactions/id/"+this.searchTxt]);
}
}
