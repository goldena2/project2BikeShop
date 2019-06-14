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

  constructor(private getServices: MyServivesService, private user: CurrUserService) { }

  ngOnInit() {
    let temp = this.getServices.getServices();
    let myServices =[];
    for(let service of temp){
      if(service['userId'] == this.user.getUser()['id']){
        myServices.push(service);
      }
    }
    this.services = myServices;
  }

  calcTime(service){
    let hour = Math.floor(service['time']/60);
    let min = service['time']%60;
    let temp = hour >= 12 ? 'PM' : 'AM';
    if(hour >12){
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
