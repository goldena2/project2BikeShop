import { CurrUserService } from './../curr-user.service';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-product-list-element',
  templateUrl: './product-list-element.component.html',
  styleUrls: ['./product-list-element.component.css']
})
export class ProductListElementComponent implements OnInit {
  @Input() product: object;
  constructor(private currUser: CurrUserService) {
    console.log(this.product);
   }

  ngOnInit() { }

   makePurchase(purchaseQuantity: number){
     if(this.currUser.user['title'] == 1){
       console.log('customer making purchase:');
     }else if (this.currUser.user['title'] == 2 || this.currUser.user['title']==3){
        console.log('employee making purchase:');
     }
     console.log('Purchase quantity:' + purchaseQuantity);
   }
}
