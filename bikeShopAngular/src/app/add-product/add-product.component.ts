import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, FormArray, FormControl, ValidatorFn, Validators } from '@angular/forms';

@Component({
  selector: 'app-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  form: FormGroup;
  ngOnInit(){


    
  }

  constructor(private formBuilder: FormBuilder, private productService: ProductService, private router: Router) { 
    this.form = this.formBuilder.group({
      //   'pName': ['', Validators.required],
      //   'upc': ['', Validators.required],
      //   'price': ['', Validators.required],
      //   'desc': ['', Validators.required],
      //   'stock': ['', Validators.required],
      //   'image': ['', Validators.required],
      //   'type': ['', Validators.required]
      });
  }

  addProduct(name: string, upc: string, price: number, description: string, stock: number, image: string, type_id: number) {
    console.log(type_id);
    this.productService.create(name, upc, price, description, stock, image, type_id).subscribe(data => {
        if(data != null){
          this.router.navigateByUrl('home');
        }else{
          alert("Unable to add a product at this time please try again later");
        }
      });
  }

  log(value){
    console.log(value);
  }
}

