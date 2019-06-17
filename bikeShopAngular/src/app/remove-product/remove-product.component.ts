import { CurrUserService } from './../curr-user.service';
import { Component, OnInit } from '@angular/core';
import { AllProductsService } from '../all-products.service';
import { ProductListElementComponent } from '../product-list-element/product-list-element.component';
import { ProductService } from '../product.service';
import { ProductListComponent } from '../product-list/product-list.component';
import { DeleteproductService } from '../deleteproduct.service';


@Component({
  selector: 'app-remove-product',
  templateUrl: './remove-product.component.html',
  styleUrls: ['./remove-product.component.css']
})
export class RemoveProductComponent implements OnInit {
products;
prodSelected:Number;
  constructor(private productListBuilder: AllProductsService, private getUser: CurrUserService, private ds: DeleteproductService) {  }
  id: number

  ngOnInit() {
    this.productListBuilder.getProducts().subscribe(data =>{
        if (data != null){
          console.log(data);
          this.products = data;
        }
    });
    
  }
  deleteProduct(id: number): void {
    // Observable call of delete HTTP request
    // If successful, notify user
    // If not successful, notify user 
    
    console.log(id+"Getting product value")
    for(var i=0; i< this.products.length; i++ ){
        if (this.products[i]["id"] == id){
          this.products.splice(i, 1)
        }


    }
    this.ds.deleteProduct(id).subscribe(data =>{
      if(data != null){
        alert("Product deleted");
      } alert("Product deleted");
    });
  }

  }




