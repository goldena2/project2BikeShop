import { PortConfigService } from './port-config.service';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient : HttpClient, private portNumber: PortConfigService) {
  }

 create(name: string, upc: string, price: number, 
   desc: string, stock: number) {
     return this.httpClient.post<boolean>('http://localhost:'+this.portNumber.getPort()+'/bikeShop/products', {
       'name': name,
       'upc': upc,
       'price': price,
       'description': desc,
       'stock': stock
     });
 }
}
