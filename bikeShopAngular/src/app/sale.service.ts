import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PortConfigService } from './port-config.service';

@Injectable({
  providedIn: 'root'
})
export class SaleService {

  constructor( private httpClient: HttpClient, private portNumber: PortConfigService ) { }

  createSale(discount: number, productID: number) {
    console.log('Getting to create sale request in sale service');
    console.log('discount: ' + discount);
    console.log('product: ' + productID);
    return this.httpClient.post<boolean>('http://localhost:' + this.portNumber.getPort() + '/bikeShop/createSale', {
      'discount': discount,
      'productID': productID,
    });
  }
  deleteSale(productID: number) {
    return this.httpClient.post<boolean>('http://localhost:' + this.portNumber.getPort() + '/bikeShop/deleteSale', {
      'productID': productID
    })
  }
  getSales(){
    return this.httpClient.get<boolean>('http://localhost:' + this.portNumber.getPort() + '/bikeShop/getSales', {
    })
  }
}
