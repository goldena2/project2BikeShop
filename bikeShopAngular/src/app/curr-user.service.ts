import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CurrUserService {
  user: any;
  constructor() {
    if (this.user == null) {
      this.user = {};
    }
  }

  getUser(){
    return this.user;
  }
  setuser(user: any){
    this.user = user;
  }

  isCustomer(): boolean{
    console.log('Checking isCustomer() in curr-user.service: ' + this.user['title']);
    if (this.user == null) { return false; }
    return this.getUser()['title'] === 1;
  }

  isManager() : boolean{
    if (this.user == null) { return false; }
    return this.getUser()['title'] === 3;
  }

  isEmployee(): boolean{
    if (this.user == null) { return false; }
    return this.getUser()['title'] === 2;
  }

}
