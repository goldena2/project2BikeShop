import { Component, OnInit } from '@angular/core';
import { ShiftScheduleService } from '../shift-schedule.service';

@Component({
  selector: 'app-personal-schedule',
  templateUrl: './personal-schedule.component.html',
  styleUrls: ['./personal-schedule.component.css']
})
export class PersonalScheduleComponent implements OnInit {

  constructor(shiftService: ShiftScheduleService) {}

  getPersonalSchedule(){}

  ngOnInit() {
  }

}
