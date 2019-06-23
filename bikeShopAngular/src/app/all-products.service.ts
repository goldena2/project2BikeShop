import { PortConfigService } from './port-config.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AllProductsService {

  constructor( private httpClient: HttpClient, private portNumber: PortConfigService ) { }

  getProducts() {
    return this.httpClient.get<boolean>('http://localhost:' + this.portNumber.getPort() + '/bikeShop/products', {
    });
  }
}
