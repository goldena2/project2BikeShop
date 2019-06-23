import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PortConfigService } from './port-config.service';

@Injectable({
  providedIn: 'root'
})
export class GetEmployeesService {

  constructor(private http :HttpClient, private portNumber : PortConfigService) { }

  getEmployees(){
    return this.http.get('http://localhost:' + this.portNumber.getPort() + '/bikeShop/getEmployees', {});
  }
}
