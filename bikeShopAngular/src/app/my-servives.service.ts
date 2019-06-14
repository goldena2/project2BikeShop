import { CurrUserService } from './curr-user.service';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PortConfigService } from './port-config.service';

@Injectable({
  providedIn: 'root'
})
export class MyServivesService {
  services : any;
  constructor(private http: HttpClient, private port: PortConfigService, private user: CurrUserService) { }

    getMyServices(){
      this.http.get('http://localhost:'+this.port.getPort()+'/bikeShop/services').subscribe(data=>{
        this.services = data;
      });
    }

    getServices(){
      return this.services;
    }
}
