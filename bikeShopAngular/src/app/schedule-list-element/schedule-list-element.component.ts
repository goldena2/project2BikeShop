import { Component, OnInit, Input } from '@angular/core';
import { CurrUserService } from '../curr-user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-schedule-list-element',
  templateUrl: './schedule-list-element.component.html',
  styleUrls: ['./schedule-list-element.component.css']
})
export class ScheduleListElementComponent implements OnInit {
@Input() schedule: object;
  constructor(private currUser: CurrUserService, private router: Router) { }


  ngOnInit() {


    
  }

}
