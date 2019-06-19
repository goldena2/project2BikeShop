import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, FormControl, ValidatorFn } from '@angular/forms';
import { ShiftScheduleService } from '../shift-schedule.service';
import { CurrUserService } from '../curr-user.service';
import { Shift } from '../shift';
import { Day } from '../day';

@Component({
  selector: 'app-personal-schedule',
  templateUrl: './personal-schedule.component.html',
  styleUrls: ['./personal-schedule.component.css']
})
export class PersonalScheduleComponent implements OnInit {
  @Input() user : Object;
  form: FormGroup;
  schedules;
  shifts: Shift[];

  constructor(private formBuilder: FormBuilder, private scheduleService: ShiftScheduleService, private currUser: CurrUserService) {
    this.form = this.formBuilder.group({
      schedules: ['']
    });
    this.user = this.currUser.getUser();
  }

  ngOnInit() {
    this.scheduleService.getSchedules().subscribe(data =>{
      if (data != null){
        console.log('Getting schedules:');
        console.log(data);
        this.schedules = data;
      }
    });
  }

  submit() {
    console.log(this.form.value.schedules);
    let shift = new Shift();
    shift.day = new Day();
    shift.scheduleId = this.form.value.schedules;
    shift.day.id = 1;
    shift.day.dayOfTheWeek = "Monday";
    console.log(shift);
    this.scheduleService.getShifts(shift).subscribe((data) =>{
      if (data != null){
        console.log('Getting shifts:');
        console.log(data);
        this.shifts = data;
      }
    })
  }
}
