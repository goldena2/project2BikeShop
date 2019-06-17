import { SubmitAvalibiltyService } from './../submit-avalibilty.service';
import { CurrUserService } from './../curr-user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-input-avalibility',
  templateUrl: './input-avalibility.component.html',
  styleUrls: ['./input-avalibility.component.css']
})
export class InputAvalibilityComponent implements OnInit {
  times: string[];
  days: string[];
  constructor(private user : CurrUserService, private submiter: SubmitAvalibiltyService) { }

  ngOnInit() {
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

  log(value){
    let avalibilties = [];
    let i = 1;
    for(let day of this.days){
      var start = (document.getElementById(day + "-start")) as HTMLSelectElement;
      var sIndex = start.selectedIndex;
      var end = (document.getElementById(day + "-end")) as HTMLSelectElement;
      var eIndex = end.selectedIndex;

      let sTime = (+this.times[sIndex].split(':')[0])*60;
      sTime += (+this.times[sIndex].split(':')[1]);

      let eTime = (+this.times[eIndex].split(':')[0])*60;
      eTime += (+this.times[eIndex].split(':')[1]);

      avalibilties[i] = {'dateId': i, 'userId': this.user.getUser()['id'] ,'startTime': sTime, 'endTime': eTime};
      i++;
    }
    console.log(avalibilties);
    let j : number;
    for(j = 1; j < 6; j++){
      this.submiter.submit(avalibilties[j]);
    }
  }

}
