import { CurrUserService } from './../curr-user.service';
import { AllProductsService } from './../all-products.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-all-products',
  templateUrl: './all-products.component.html',
  styleUrls: ['./all-products.component.css']
})
export class AllProductsComponent implements OnInit {
  products;
  constructor(private productListBuilder: AllProductsService, private getUser: CurrUserService) { }

  ngOnInit() {
    this.productListBuilder.getProducts().subscribe(data =>{
      if(data != null){
        console.log(data);
        this.products = data;
      }
  });
  }
}
