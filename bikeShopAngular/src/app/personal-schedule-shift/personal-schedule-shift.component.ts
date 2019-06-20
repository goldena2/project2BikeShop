import { Component, OnInit, Input } from '@angular/core';
import { Shift } from '../shift';

@Component({
  selector: 'app-personal-schedule-shift',
  templateUrl: './personal-schedule-shift.component.html',
  styleUrls: ['./personal-schedule-shift.component.css']
})
export class PersonalScheduleShiftComponent implements OnInit {
  @Input() shift: Shift;
  constructor() { }

  ngOnInit() {
  }

}
