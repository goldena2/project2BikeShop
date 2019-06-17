import { Component, OnInit } from '@angular/core';
import { AllSchedulesService } from '../all-schedules.service';
import { CurrUserService } from '../curr-user.service';

@Component({
  selector: 'app-schedule-list',
  templateUrl: './schedule-list.component.html',
  styleUrls: ['./schedule-list.component.css']
})
export class ScheduleListComponent implements OnInit {
  schedules;
  constructor(private scheduleListBuilder: AllSchedulesService, private getUser: CurrUserService) { }

  ngOnInit() {
    this.scheduleListBuilder.getSchedules().subscribe(data =>{
      if (data!=null){
        console.log('Getting new data:');
        console.log(data);
        this.schedules = data;
      }      
    });
  }

}
