import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddaccountComponent } from './addaccount/addaccount.component';
import { DebitslipComponent } from './debitslip/debitslip.component';
import { CreditslipComponent } from './creditslip/creditslip.component';
import { DebitchequeComponent } from './debitcheque/debitcheque.component';
import { CreditchequeComponent } from './creditcheque/creditcheque.component';
import { TransactionComponent } from './transaction/transaction.component';
import { LoanrequestComponent } from './loanrequest/loanrequest.component';
import { VeiwTransactionsComponent } from './veiw-transactions/veiw-transactions.component';
import { RegisterComponent } from './register/register.component';
import { EmployeeComponent } from './employee/employee.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {
    path : "employee/addaccount"             ,component : AddaccountComponent
  },
  {
    path : "employee/transaction"           ,component : TransactionComponent
  },
  {
    path : "employee/transaction/creditcheque"        ,component :CreditchequeComponent
  },
  {
    path : "employee/transaction/debitcheque"   ,component :DebitchequeComponent
  },
  {
    path : "employee/transaction/creditslip"        ,component :CreditslipComponent
  },
  {
    path : "employee/transaction/debitslip"   ,component :DebitslipComponent
  },
  {
    path :"employee/loanrequest"      ,component :LoanrequestComponent
  },
  {
    path :"view-transactions/id/:id"      ,component :VeiwTransactionsComponent
  },
  {
    path:"login", component:LoginComponent
  },
  {
    path:"register", component: RegisterComponent
  },
  {
    path:"employee", component:EmployeeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
