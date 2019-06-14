import { CurrUserService } from './../curr-user.service';
import { GetUserService } from './../get-user.service';
import { ScheduledServicesService } from './../scheduled-services.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-schedule-service',
  templateUrl: './schedule-service.component.html',
  styleUrls: ['./schedule-service.component.css']
})
export class ScheduleServiceComponent implements OnInit {
  date;
  constructor(private scheduler: ScheduledServicesService, private user: CurrUserService) { }

  ngOnInit() {
  }

  log(value){
    console.log(value.value);
  }
  submitForm(desc: string, day: string , time: string, bike: string){
      console.log(this.user.getUser());
      let splittime = time.split(':');
      let numTime = 0;
      numTime = (+splittime[0])*60 + (+splittime[1]);
      this.scheduler.makeServiceRequest(desc, day, numTime, bike, this.user.getUser()['id']).subscribe();
  }

}
