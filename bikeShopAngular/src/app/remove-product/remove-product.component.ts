import { CurrUserService } from './../curr-user.service';
import { Component, OnInit } from '@angular/core';
import { AllProductsService } from '../all-products.service';


@Component({
  selector: 'app-remove-product',
  templateUrl: './remove-product.component.html',
  styleUrls: ['./remove-product.component.css']
})
export class RemoveProductComponent implements OnInit {
products;
  constructor(private productListBuilder: AllProductsService, private getUser: CurrUserService) {
  }

  ngOnInit() {
    this.productListBuilder.getProducts().subscribe(data =>{
        if (data != null){
          console.log(data);
          this.products = data;
        }
    });
  }
}
