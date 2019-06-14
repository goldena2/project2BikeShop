import { CurrUserService } from './../curr-user.service';
import { Component, OnInit } from '@angular/core';
import { MyServivesService } from '../my-servives.service';

@Component({
  selector: 'app-my-services',
  templateUrl: './my-services.component.html',
  styleUrls: ['./my-services.component.css']
})
export class MyServicesComponent implements OnInit {
  services: any;

  constructor(private getServices: MyServivesService, private user: CurrUserService) { 
    this.services = getServices.getServices();
    for(var i; i < this.services.length; i++){
      console.log(this.services[i]);
      console.log(this.user.getUser()['id']);
      if(this.services[i]['userId'] != this.user.getUser()['id']){
        delete this.services[i];
      }
    }
  }

  ngOnInit() {
    this.services = this. getServices.getServices();
  }

  calcTime(service){
    let hour = Math.floor(service['time']/60);
    let min = service['time']%60;
    let temp = 'AM';
    if(hour > 12){
      hour -= 12;
      temp = 'PM';
    }
    return hour+':'+min+temp;
  }

  isId(id: number){
    console.log(id);
    return id === this.user.getUser()['id'];
  }

}
