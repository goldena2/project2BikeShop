import { Component, OnInit } from '@angular/core';
import { MakeAccountService } from '../make-account.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-make-customer-acount',
  templateUrl: './make-customer-acount.component.html',
  styleUrls: ['./make-customer-acount.component.css']
})
export class MakeCustomerAcountComponent{
  constructor(private accountBuilder : MakeAccountService, private router: Router) { 
  }


  makeAcount(username: string, password: string, number: string, fname: string, lname: string, email:string) {
    this.accountBuilder.create(username, password, number, fname, lname, email, 1).subscribe(data => {
        if(data['success']){
          this.router.navigateByUrl('');
        }else{
          alert("Unable to make an account at this time please try again later");
        }
      });
  }
}
