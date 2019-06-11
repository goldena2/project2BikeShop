import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  @Input() otherLinks: object[];


  constructor() { 
    console.log(this.otherLinks);
  }

  ngOnInit() {
  }

}
