import { PortConfigService } from './port-config.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SubmitAvalibiltyService {

  constructor(private http: HttpClient, private port: PortConfigService) { }

  submit(avalibilty: object){
    console.log(avalibilty);
    this.http.post('http://localhost:' + this.port.getPort() + '/bikeShop/submitAvalibility', avalibilty).subscribe();
  }
}
