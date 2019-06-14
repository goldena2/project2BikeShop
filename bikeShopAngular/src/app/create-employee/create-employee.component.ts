import { Component, OnInit } from '@angular/core';
import { MakeAccountService } from '../make-account.service';
import { Router } from '@angular/router';

@Component({
  selector: 'create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent{
  constructor(private accountBuilder : MakeAccountService, private router: Router) { 
  }


  makeAcount(username: string, password: string, number: string, fname: string, lname: string, email:string) {
    this.accountBuilder.create(username, password, number, fname, lname, email, 2).subscribe(data => {
        if(data['success']){
          this.router.navigateByUrl('home');
        }else{
          alert(data['message']);
        }
      });
  }
}
