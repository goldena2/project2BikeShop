import { CurrUserService } from './../curr-user.service';
import { Router } from '@angular/router';
import { LoginService } from './../login.service';
import { Component } from '@angular/core';

@Component({
  selector: 'front-page',
  templateUrl: './front-page.component.html',
  styleUrls: ['./front-page.component.css']
})


export class FrontPageComponent {
  constructor(private loginBuilder: LoginService, private router: Router, private getUser: CurrUserService) {
    getUser.setuser({'title': -1});
  }

  login(username: string, password: string){
    this.loginBuilder.login(username, password).subscribe(data =>{
      if(data != null){
        this.getUser.setuser(data);
        console.log(data)
        this.router.navigateByUrl('home');
      }else{
        alert('Invalid log in. Try again.');
      }
  });
  }
}
