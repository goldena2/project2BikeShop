import { Router } from '@angular/router';
import { LoginService } from './../login.service';
import { Component } from '@angular/core';

@Component({
  selector: 'front-page',
  templateUrl: './front-page.component.html',
  styleUrls: ['./front-page.component.css']
})


export class FrontPageComponent {
  constructor(private loginBuilder: LoginService, private router: Router) {}

  login(username: string, password: string){
    this.loginBuilder.login(username, password).subscribe(data =>{
      console.log(data);
  });
  }
}
