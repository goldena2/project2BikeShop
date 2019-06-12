import { GetUserService } from '../get-user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  currUser : Object;
  constructor(private userService: GetUserService) { 
    if(this.currUser == null){
      this.currUser = {
        'fname' : ''
      }
    }
  }

  ngOnInit() {
    this.userService.getUser().subscribe(data => {
      this.currUser = data;
    });
  }

}
