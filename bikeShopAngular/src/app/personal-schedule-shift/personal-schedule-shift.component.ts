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

  calcTime(time:number){
    let hour = Math.floor(time/60);
    let min = time%60;
    if(hour > 12){
      hour -= 12;
    }
    return hour + ':' + (min>=10 ? min : min + '0'); 
  }

}
