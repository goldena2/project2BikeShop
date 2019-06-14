import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-product-list-element',
  templateUrl: './product-list-element.component.html',
  styleUrls: ['./product-list-element.component.css']
})
export class ProductListElementComponent implements OnInit {
  @Input() product : object;
  constructor() {
    console.log(this.product);
   }

  ngOnInit() {
  }

}
