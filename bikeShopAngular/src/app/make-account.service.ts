import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class MakeAccountService {

  constructor(private httpClient : HttpClient) {
   }

  create(username: string, password: string, number: string, 
    fname: string, lname: string, email:string, type: number) {
      return this.httpClient.post<Boolean>('http://localhost:8081/bikeShop/createAccount', {
        'username': username,
        'password': password,
        'phoneNumber': number,
        'fname': fname,
        'lname': lname,
        'email': email,
        'title': type,
      });
  }
}
