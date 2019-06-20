import { Component, OnInit } from '@angular/core';
import { AllSchedulesService } from '../all-schedules.service';
import { CurrUserService } from '../curr-user.service';
import { ViewallSchedulesService } from '../viewall-schedules.service';

@Component({
  selector: 'app-viewall-schedules',
  templateUrl: './viewall-schedules.component.html',
  styleUrls: ['./viewall-schedules.component.css']
})
export class ViewallSchedulesComponent implements OnInit {
schedules;

  constructor(private scheduleListBuilder: ViewallSchedulesService, private getUser: CurrUserService, private vs: ViewallSchedulesService) { }
  id: number

  ngOnInit() {
    // this.scheduleListBuilder.viewSchedules().subscribe(data =>{
    //   if (data != null){
    //     console.log(data);
    //     this.schedules = data;
    //   }
    // });
  }
  // viewSchedule(id: number) {
  //   for(var i=0; i< this.schedules.length; i++ ){
  //     if (this.schedules[i]["id"] == id){
  //       this.schedules.splice(i, 1)
  // }

}  
// this.vs.viewSchedules(id).subscribe(data =>{
//   if (data != null){
//     alert("View Schedule");
//   } alert("View Schedule");
// });

