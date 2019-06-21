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

  constructor(private shiftListBuilder:  ViewShiftsService ,private currUser: CurrUserService, private router: Router) { }
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


    
  

}
