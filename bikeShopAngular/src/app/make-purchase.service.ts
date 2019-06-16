import { CurrUserService } from './curr-user.service';
import { PortConfigService } from './port-config.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MakePurchaseService {

  constructor(private httpClient: HttpClient, private portNumber: PortConfigService, private currUser: CurrUserService) {
   }

  makePuchase(product: object) {
    return this.httpClient.post<boolean>('http://localhost:' + this.portNumber.getPort() + '/bikeShop/products/makePurchase', {

      // 'product': product,
      'id': product['id'],
      'name': product['name'],
      'upc': product['upc'],
      'price': product['price'],
      'description': product['description'],
      'stock': product['stock'],
      'image': product['image'],
      'type_id': product['type_id'],
    });
  }
  createInvoice(product: object, purchaseQuantity: number) {
    const user = this.currUser.getUser();
    console.log("User ID: " + user['id']);
    return this.httpClient.post<boolean>('http://localhost:' + this.portNumber.getPort() + '/bikeShop/products/createInvoice', {
      'product_id': product['id'],
      'user_id': user['id'],
      'quantity': purchaseQuantity,
      'unitPrice': product['price']
    });
  }
}
