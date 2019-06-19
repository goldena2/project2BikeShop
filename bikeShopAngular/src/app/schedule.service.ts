import { PortConfigService } from './port-config.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ScheduleService {

  constructor(private http: HttpClient, private port: PortConfigService) { }

  generateSchedule(start, end){
    this.http.post('http://localhost:' + this.port.getPort() + '/bikeShop/generateSchedule',[start, end]).subscribe();
  }
}
