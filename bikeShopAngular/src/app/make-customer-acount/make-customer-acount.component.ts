import { Component, OnInit } from '@angular/core';
import { MakeAccountService } from '../make-account.service';

@Component({
  selector: 'app-make-customer-acount',
  templateUrl: './make-customer-acount.component.html',
  styleUrls: ['./make-customer-acount.component.css']
})
export class MakeCustomerAcountComponent{
  constructor(private accountBuilder : MakeAccountService) { 
  }


  makeAcount(username: string, password: string, number: string, fname: string, lname: string, email:string){
    this.accountBuilder.create(username, password, number, fname, lname, email, 'customer').subscribe(data => {
        if(data['success']){
          console.log('wat')
        }
      });
  }

}
