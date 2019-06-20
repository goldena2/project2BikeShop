import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PortConfigService } from './port-config.service';

@Injectable({
  providedIn: 'root'
})
export class ViewallSchedulesService {

  constructor(private httpClient: HttpClient, private portNumber: PortConfigService) { }

  getSchedules(){
  return this.httpClient.get<boolean>('http://localhost:' + this.portNumber.getPort() + '/bikeShop/allSchedules', {
  });
  }
}
