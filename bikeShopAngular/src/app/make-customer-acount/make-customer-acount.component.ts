import { Component, OnInit } from '@angular/core';
import { MakeAccountService } from '../make-account.service';

@Component({
  selector: 'app-make-customer-acount',
  templateUrl: './make-customer-acount.component.html',
  styleUrls: ['./make-customer-acount.component.css']
})
export class MakeCustomerAcountComponent{
  accountBuilder : MakeAccountService;
  constructor(accountBuilder : MakeAccountService) { 
    this.accountBuilder = accountBuilder;
  }


  makeAcount(username: string, password: string, number: string, fname: string, lname: string, email:string){
    this.accountBuilder.create(username, password, number, fname, lname, email, 'customer');
  }

}
