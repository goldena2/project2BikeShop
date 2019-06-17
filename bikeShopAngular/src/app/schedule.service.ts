import { PortConfigService } from './port-config.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ScheduleService {

  constructor(private http: HttpClient, private port: PortConfigService) { }

  generateSchedule(){
    this.http.post('http://localhost:' + this.port.getPort() + '/bikeShop/generateSchedule',['day1', 'day2']).subscribe();
  }
}
