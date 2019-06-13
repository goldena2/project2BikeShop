import { PortConfigService } from './port-config.service';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class MakeAccountService {

  constructor(private httpClient : HttpClient, private portNumber: PortConfigService) {
   }

  create(username: string, password: string, number: string, 
    fname: string, lname: string, email:string, type: number) {
      return this.httpClient.post<boolean>('http://localhost:'+this.portNumber.getPort()+'/bikeShop/createAccount', {
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
