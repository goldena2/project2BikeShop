import { Component, OnInit } from '@angular/core';

import { CurrUserService } from '../curr-user.service';
import { ViewallSchedulesComponent } from '../viewall-schedules/viewall-schedules.component';
import { ViewallSchedulesService } from '../viewall-schedules.service';
import { ViewShiftsService } from '../view-shifts.service';
import { GetEmployeesService } from '../get-employees.service'

@Component({
  selector: 'app-schedule-list',
  templateUrl: './schedule-list.component.html',
  styleUrls: ['./schedule-list.component.css']
})
export class ScheduleListComponent implements OnInit {
  schedules;
  shifts;
  shift;
  id: number;
  addNew: boolean;
  employees;
  days: string[];
  times: string[];

  constructor(private emps: GetEmployeesService, private scheduleListBuilder: ViewallSchedulesService, private getUser: CurrUserService, private shts: ViewShiftsService) { 
    this.emps.getEmployees().subscribe(data=>{
      this.employees = data;
    });
    this.times = [
      '08:00',
      '08:30',
      '09:00',
      '10:00',
      '10:30',
      '11:00',
      '11:30',
      '12:00',
      '12:30',
      '13:00',
      '13:30',
      '14:00',
      '14:30',
      '15:00',
      '15:30',
      '16:00',
      '16:30',
    ];
    this.days = [
      'Monday',
      'Tuesday',
      'Wednesday',
      'Thursday',
      'Friday',
    ];
  }
  

  ngOnInit() {
    this.scheduleListBuilder.getSchedules().subscribe(data => {
      if (data != null) {
        console.log('Getting new data:');
        console.log(data);
        this.schedules = data;
      }
    });

  }
   getShifts(id: number) {
     this.id = id;
     if(id ! > 0){
       this.addNew = false;
     }
     console.log(id +'Getting shifts');
     for (let i = 0; i < this.shifts; i++ ) {
      if (this.shifts[i]['id'] == id) {
        console.log('hi');
      }

  }
     this.shts.getShifts(id).subscribe(data => {
    if (data != null) {
      this.shifts = data;



    }
  });
}
  openAddShift(){
    this.addNew = true;
  }

  addShift(data){
    this.addNew = false;
    data['scheduleId'] = this.id;
    data['startTime'] = this.generateTime(data['startTime']);
    data['endTime'] = this.generateTime(data['endTime']);
    data['day'] = {'id': data['day']};
    data['user'] = {'id': data['userId']};
    this.shts.addShift(data).subscribe(data=>{
      this.getShifts(this.id);
    });
  }
  cancel(){
    this.addNew = false;
  }

  generateTime(timeStr){
    let time;
    let pieces = timeStr.split(':');
    time = 60*pieces[0] + (+pieces[1]);
    return time;

  }

}
