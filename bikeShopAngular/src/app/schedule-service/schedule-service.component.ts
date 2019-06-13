import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-schedule-service',
  templateUrl: './schedule-service.component.html',
  styleUrls: ['./schedule-service.component.css']
})
export class ScheduleServiceComponent implements OnInit {
  date;
  constructor() { }

  ngOnInit() {
  }

  log(value){
    console.log(value.value);
  }
  submitForm(desc: string, date: string , time: string, bike: string){
    console.log(date);
    console.log(desc);
    console.log(bike);

  }

}
