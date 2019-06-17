import { getTestBed } from '@angular/core/testing';
import { CurrUserService } from './../curr-user.service';
import { AllProductsService } from '../all-products.service';
import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-all-products',
  templateUrl: './all-products.component.html',
  styleUrls: ['./all-products.component.css']
})
export class AllProductsComponent {
  constructor(private router: Router, private currUser: CurrUserService) {
  }
}
