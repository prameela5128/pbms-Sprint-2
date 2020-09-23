import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddaccountComponent } from './addaccount/addaccount.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LoanrequestComponent } from './loanrequest/loanrequest.component';
import { TransactionComponent } from './transaction/transaction.component';
import { CreditslipComponent } from './creditslip/creditslip.component';
import { CreditchequeComponent } from './creditcheque/creditcheque.component';
import { DebitslipComponent } from './debitslip/debitslip.component';
import { DebitchequeComponent } from './debitcheque/debitcheque.component';
import { VeiwTransactionsComponent } from './veiw-transactions/veiw-transactions.component';
import { AccountComponent } from './account/account.component';
import { UpdateAccountComponent } from './update-account/update-account.component';
import { UpdateNameComponent } from './update-name/update-name.component';
import { UpdateContactComponent } from './update-contact/update-contact.component';
import { UpdateAddressComponent } from './update-address/update-address.component';
import { DeleteaccountComponent } from './deleteaccount/deleteaccount.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { EmployeeComponent } from './employee/employee.component';

@NgModule({
  declarations: [
    AppComponent,
    AddaccountComponent,
    HeaderComponent,
    FooterComponent,
    LoanrequestComponent,
    TransactionComponent,
    CreditslipComponent,
    CreditchequeComponent,
    DebitslipComponent,
    DebitchequeComponent,
    VeiwTransactionsComponent,
    AccountComponent,
    UpdateAccountComponent,
    UpdateNameComponent,
    UpdateContactComponent,
    UpdateAddressComponent,
    DeleteaccountComponent,
    LoginComponent,
    RegisterComponent,
    EmployeeComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
