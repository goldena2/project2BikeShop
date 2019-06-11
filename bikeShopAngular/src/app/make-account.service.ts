import { Injectable } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MakeAccountService {

  httpClient : HttpClientModule;

  constructor(httpClient : HttpClientModule) {
    this.httpClient = httpClient;
   }

  create(username: string, password: string, number: string, fname: string, lname: string, email:string, type: string){
    this.httpClient;
  }
}
