import { CurrUserService } from './../curr-user.service';
import { AllProductsService } from './../all-products.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products;
  constructor(private productListBuilder: AllProductsService, private getUser: CurrUserService) { }

ngOnInit() {
  this.productListBuilder.getProducts().subscribe(data =>{
    if (data != null){
      console.log('Getting new data:');
      console.log(data);
      this.products = data;
    }
});
}
}
