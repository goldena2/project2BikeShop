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
    if(this.services == null){
      this.services = [];
    }
  }

  ngOnInit() {
    this.getServices.getMyServices().subscribe(data=>{
      this.services = data;
      let i = 0;
      for (let entry of this.services){
        if(entry['userId'] != this.user.getUser()['id']){
          delete data[i];
        }
      }
    });
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
    return id == this.user.getUser()['id'];
  }

}
