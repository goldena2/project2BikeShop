import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PortConfigService } from './port-config.service';

@Injectable({
  providedIn: 'root'
})
export class ViewShiftsService {
  length: number;

  constructor( private httpClient: HttpClient, private portNumber: PortConfigService) { }

  getShifts(id:number){
    return this.httpClient.get('http://localhost:' + this.portNumber.getPort() + '/bikeShop/schedules/' + id)
  }

  removeShift(id: number){
    return this.httpClient.post('http://localhost:' + this.portNumber.getPort() + '/bikeShop/schedules/deleteShift', id);
  }

  addShift(data: object){
    return this.httpClient.post('http://localhost:' + this.portNumber.getPort() + '/bikeShop/schedules/addShift', data);
  }
}
