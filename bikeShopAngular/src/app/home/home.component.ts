import { ScheduleService } from './../schedule.service';
import { Router } from '@angular/router';
import { CurrUserService } from './../curr-user.service';
import { GetUserService } from '../get-user.service';
import { Component, OnInit, Input } from '@angular/core';
import { MyServivesService } from '../my-servives.service';
import { AllProductsService } from '../all-products.service';
import { ProductService } from '../product.service';
import { FormBuilder, FormGroup, FormArray, FormControl, ValidatorFn } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  @Input() user : Object;
  form: FormGroup;
  links : Object[];
  products;
  constructor(private formBuilder: FormBuilder, private generator: ScheduleService,private services: MyServivesService, private currUser: CurrUserService, private router: Router, private allProducts: AllProductsService) { 
    this.user = this.currUser.getUser();
    this.form = this.formBuilder.group({});
    services.getMyServices();
    if(this.user){
      console.log(this.user['fname']);
    }
    this.links = [
      {'link': 'allProducts', 'name': 'All Products'},
      {'link': 'scheduleService', 'name': 'Schedule Services'}
      ];
      if(this.currUser.getUser['title'] == 1){
        this.links.push({'link': 'myServices','name': 'My services'});
      }
  }

  ngOnInit() {
    if(this.currUser.getUser()['id'] == -1){
      this.router.navigateByUrl('');
    }
    if(this.getType() == 'employee'){
      this.allProducts.getProducts().subscribe(data =>{
        if (data != null){
          console.log('Getting new data:');
          console.log(data);
          this.products = data;
          console.log(this.products);
          let alertString = "";
          for (let product of this.products) {
            if (product.stock == 0) {
              alertString += product.name+" Product ID: "+product.id+", stock empty.\n";
            }
          }
          if (alertString != "")
            alert(alertString);
        }
      });
    }
  }

  getCurrUser(): string{
    return this.currUser.getUser()['fname'];
  }

  getType(): string{
    return this.currUser.getUser()['title'] == 1 ? 'customer' : this.currUser.getUser()['title'] == 2 ? 'employee' : 'manager';
  }

  getTypeId() : number{
    return this.currUser.getUser()['title'];
  }

  generateSchedule(start: string, end: string){
    this.generator.generateSchedule(start, end);
  }
}
