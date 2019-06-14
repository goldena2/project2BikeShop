import { PortConfigService } from './port-config.service';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient: HttpClient, private portNumber: PortConfigService) {
  }

<<<<<<< HEAD
 create(name: string, upc: string, price: number,
        desc: string, stock: number) {
     return this.httpClient.post<boolean>('http://localhost:' + this.portNumber.getPort() + '/bikeShop/products', {
       'name': name,
       'upc': upc,
       'price': price,
       'description': desc,
       'stock': stock
=======
 create(name: string, upc: string, price: number, 
   desc: string, stock: number, image: string, type_id: number) {
     return this.httpClient.post<boolean>('http://localhost:'+this.portNumber.getPort()+'/bikeShop/products', {
        'name': name,
        'upc': upc,
        'price': price,
        'description': desc,
        'stock': stock,
        'image': image,
        'type_id': type_id
>>>>>>> 5459d0cf477f44e70844cb29ed98bf3950a0a527
     });
 }
}
