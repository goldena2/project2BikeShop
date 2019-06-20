import { Component, OnInit } from '@angular/core';
import { MakeAccountService } from '../make-account.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, FormArray, FormControl, ValidatorFn } from '@angular/forms';

@Component({
  selector: 'create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent{
  form: FormGroup;
  constructor(private formBuilder: FormBuilder, private accountBuilder : MakeAccountService, private router: Router) { 
    this.form = this.formBuilder.group({});
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
