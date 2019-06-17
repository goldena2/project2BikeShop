import { AllProductsService } from './../all-products.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sales',
  templateUrl: './sales.component.html',
  styleUrls: ['./sales.component.css']
})
export class SalesComponent implements OnInit {
  products;
  constructor(private allProducts: AllProductsService) { }

  ngOnInit() {
    this.allProducts.getProducts().subscribe(data => {
      if (data != null) {
        console.log(data);
        this.products = data;
      }
  });
  }

}
