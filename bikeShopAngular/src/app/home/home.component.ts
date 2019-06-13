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
  constructor(private userService: GetUserService, private currUser: CurrUserService) { 
    this.user = this.currUser.getUser();
    if(this.user){
      console.log(this.user['fname']);
    }
  }

  ngOnInit() {
    this.user = this.currUser.getUser();
    console.log(this.user);
  }

  getCurrUser(): string{
    return this.currUser.getUser()['fname'];
  }

}
