import { AllProductsService } from './../all-products.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, FormControl, ValidatorFn } from '@angular/forms';
import { map } from 'rxjs/operators';
import { SaleService } from '../sale.service';

@Component({
  selector: 'app-sales',
  templateUrl: './sales.component.html',
  styleUrls: ['./sales.component.css']
})
export class SalesComponent implements OnInit {
  products;
  form: FormGroup;
  constructor(private formBuilder: FormBuilder, private manageSale: SaleService, private allProducts: AllProductsService) { 
    this.form = this.formBuilder.group({});
  }

  ngOnInit() {
    this.allProducts.getProducts().subscribe(data => {
      if (data != null) {
        this.products = data;
      }
    });
  }
  createSale(discount: number, productID: number){
    console.log('Getting createSale call, sending: ' + discount + ' and: ' + productID);
    this.manageSale.createSale(discount, productID).subscribe(data => {
    });
  }
}
