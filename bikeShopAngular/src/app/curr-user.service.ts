import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CurrUserService {
  user : any;
  constructor() { 
    if(this.user == null){
      this.user = {};
    }
  }

  getUser(){
    return this.user;
  }
  setuser(user: any){
    this.user = user;
  }
}
