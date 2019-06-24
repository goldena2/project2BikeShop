import { SaleService } from './../sale.service';
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
  sales;
  constructor(private productListBuilder: AllProductsService, private getUser: CurrUserService, private saleService: SaleService) { }

  ngOnInit() {
    this.productListBuilder.getProducts().subscribe(data =>{
      if (data != null){
        console.log('Getting new product list data:');
        console.log(data);
        this.products = data;
      }
    });
    this.saleService.getSales().subscribe(salesData =>{
      if(salesData != null){
        this.sales = salesData;
      }
    });
  }
}
