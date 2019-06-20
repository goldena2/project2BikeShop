import { Component, OnInit } from '@angular/core';
import { AllSchedulesService } from '../all-schedules.service';
import { CurrUserService } from '../curr-user.service';
import { ViewallSchedulesComponent } from '../viewall-schedules/viewall-schedules.component';
import { ViewallSchedulesService } from '../viewall-schedules.service';
import { ViewShiftsService } from '../view-shifts.service';

@Component({
  selector: 'app-schedule-list',
  templateUrl: './schedule-list.component.html',
  styleUrls: ['./schedule-list.component.css']
})
export class ScheduleListComponent implements OnInit {
  schedules;
  shifts;
  shift;
  constructor(private scheduleListBuilder: ViewallSchedulesService, private getUser: CurrUserService, private shts: ViewShiftsService) { }
  id: number

  ngOnInit() {
    this.scheduleListBuilder.getSchedules().subscribe(data =>{
      if (data != null){
        console.log('Getting new data:');
        console.log(data);
        this.schedules = data;

    
      }      
    });
    
  }
   getShifts(id: number){
     console.log(id+"Getting shifts")
    for(var i=0; i< this.shifts; i++ ){
      if (this.shifts[i]["id"] == id){ 
        console.log("hi");
      }

  }
  this.shts.getShifts(id).subscribe(data =>{
    if (data != null){
      console.log('Getting new data:');
      console.log(data);
      this.shifts=data;

      

    }
  });
}
}
