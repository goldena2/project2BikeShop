import { Router } from '@angular/router';
import { CurrUserService } from './../curr-user.service';
import { GetUserService } from '../get-user.service';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  @Input() user : Object;
  constructor(private userService: GetUserService, private currUser: CurrUserService, private router: Router) { 
    this.user = this.currUser.getUser();
    if(this.user){
      console.log(this.user['fname']);
    }
  }

  ngOnInit() {
    if(!this.currUser.getUser()){
      this.router.navigateByUrl('');
    }
  }

  getCurrUser(): string{
    return this.currUser.getUser()['fname'];
  }

  getType(): string{
    return this.currUser.getUser()['title'] == 1 ? 'customer' : this.currUser.getUser()['title'] == 2 ? 'employee' : 'manager';
  }

}
