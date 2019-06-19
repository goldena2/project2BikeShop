import { AllProductsService } from './../all-products.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, FormControl, ValidatorFn } from '@angular/forms';

@Component({
  selector: 'app-sales',
  templateUrl: './sales.component.html',
  styleUrls: ['./sales.component.css']
})
export class SalesComponent implements OnInit {
  products;
  form: FormGroup;
  constructor(private formBuilder: FormBuilder, private allProducts: AllProductsService) { 
    this.form = this.formBuilder.group({});
  }

  ngOnInit() {
    this.allProducts.getProducts().subscribe(data => {
      if (data != null) {
        console.log(data);
        this.products = data;
      }
  });
  }

}
