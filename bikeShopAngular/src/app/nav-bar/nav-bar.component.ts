import { CurrUserService } from './../curr-user.service';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})

export class NavBarComponent{
  @Input() otherLinks: object[];


  constructor(private currUser: CurrUserService) {}

  isCustomer(): boolean{
    if (this.currUser.user == null) { return false; }
    return this.currUser.getUser()['title'] == 1;
  }

  isManager() : boolean{
    if (this.currUser.user == null) { return false; }
    return this.currUser.getUser()['title'] == 3;
  }

  isEmployee(): boolean{
    if (this.currUser.user == null) { return false; }
    return this.currUser.getUser()['title'] == 2;
  }

}
