import { PortConfigService } from './port-config.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GetUserService {

  constructor(private http :HttpClient, private portNumber : PortConfigService) { }

  getUser(){
    return this.http.get('http://localhost:' + this.portNumber.getPort() + '/bikeShop/getUser', {withCredentials: true});
  }
}
