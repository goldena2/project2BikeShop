import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  ngOnInit(){}

  constructor(private productService: ProductService, private router: Router) { }

  addProduct(name: string, upc: string, price: number, description: string, stock: number) {
    this.productService.create(name, upc, price, description, stock).subscribe(data => {
        if(data != null){
          this.router.navigateByUrl('home');
        }else{
          alert("Unable to add a product at this time please try again later");
        }
      });
  }

}
