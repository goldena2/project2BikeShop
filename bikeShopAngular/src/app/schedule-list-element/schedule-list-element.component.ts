import { Component, OnInit, Input } from '@angular/core';
import { CurrUserService } from '../curr-user.service';
import { Router } from '@angular/router';
import { ViewShiftsService } from '../view-shifts.service';

@Component({
  selector: 'app-schedule-list-element',
  templateUrl: './schedule-list-element.component.html',
  styleUrls: ['./schedule-list-element.component.css']
})
export class ScheduleListElementComponent implements OnInit {
@Input() shift: object;
notGone: boolean;

  constructor(private shiftListBuilder:  ViewShiftsService ,private currUser: CurrUserService, private router: Router) { 
    this.notGone = true;
  }
  id: number
  ngOnInit(){
  //   this.shiftListBuilder.getShifts(id).subscribe(data =>{
  //     if (data != null){
  //       console.log('Getting new data:');
  //       console.log(data);
  //       this.shifts = data;
  //     }
  // });
  }

  getTime(time: number): string{
    let hour = Math.floor(time / 60);
    if(hour > 12){
      hour -= 12;
    }
    const min = time % 60;
    let format = hour + ':' + min;
    if (min === 0){
      format += '0';
    }
    return format;
  }
  
  removeShift(id: number){
    this.shiftListBuilder.removeShift(id).subscribe(data => {
        this.notGone = false;
      }
    )
    console.log(id);
  }


    
  

}
