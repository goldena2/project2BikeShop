import { Router } from '@angular/router';
import { MakePurchaseService } from './../make-purchase.service';
import { CurrUserService } from './../curr-user.service';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-product-list-element',
  templateUrl: './product-list-element.component.html',
  styleUrls: ['./product-list-element.component.css']
})
export class ProductListElementComponent implements OnInit {
  @Input() product: object;
  constructor(private currUser: CurrUserService, private makePurchaseRequest: MakePurchaseService, private router: Router) { }

  ngOnInit() { }

   makePurchase(purchaseQuantity: number) {
     if (this.currUser.user.title === 1) {
       console.log('this.product[stock]= ' + this.product['stock']);
       console.log('purchaseQ= ' + purchaseQuantity);
       if (purchaseQuantity > this.product['stock']) {
         alert('Stock is too low to fulfill this purchase!');
         console.log('not sending request: stock too low');
         return null;
       } else {
        console.log('customer making purchase: \n Purchase quantity:' + purchaseQuantity);
        this.product['stock'] -= purchaseQuantity;
        console.log('New quantity will be: ' + this.product['stock']);
        this.makePurchaseRequest.makePuchase(this.product).subscribe(data => {
          // insert return logic here
        });
        console.log('purchaseQuantity: ' + purchaseQuantity);
        this.makePurchaseRequest.createInvoice(this.product, purchaseQuantity).subscribe(data => {
          // insert return logic here
        });
      }
      } else if (this.currUser.user.title === 2 || this.currUser.user.title === 3) {
          console.log('employee restocking: \n Purchase quantity:' + purchaseQuantity);
          const newQuantity = Number(this.product['stock']) + Number(purchaseQuantity);
          this.product['stock'] = newQuantity;
          console.log('New quantity will be: ' + newQuantity);
          console.log(this.product['stock']);
          this.makePurchaseRequest.makePuchase(this.product).subscribe(data => {
            // insert return logic here
          });
     } else {
        alert('Please log in before trying to make a purchase!');
        this.router.navigateByUrl('');
     }
   }
}
