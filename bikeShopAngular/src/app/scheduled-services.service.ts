import { PortConfigService } from './port-config.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ScheduledServicesService {

  constructor(private http: HttpClient, private port: PortConfigService) { }

  makeServiceRequest(desc: string, day: string , time: number, bike: string, id){
    console.log('wat')
    return this.http.post<boolean>('http://localhost:'+this.port.getPort()+'/bikeShop/services', {
      'userId': id,
      'desc' : desc,
      'day': day,
      'time': time
    });
  }
}
