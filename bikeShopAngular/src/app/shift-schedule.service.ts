import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Shift } from './shift';
import { map } from 'rxjs/operators';
import { Observable, from } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ShiftScheduleService {

  constructor(private httpClient: HttpClient) { }

  getSchedules() {
    return this.httpClient.get<boolean>('http://localhost:8080/bikeShop/schedules', {
    });
  }

  getShifts(shift: Shift): Observable<Shift[]> {
    const body = JSON.stringify(shift);
    console.log(body);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.httpClient.post('http://localhost:8080/bikeShop/personalSchedule', 
      body, {headers, withCredentials: true}).pipe(
        map((resp) => resp as Shift[])
    );
  }

  removeShift(id: number){

  }


}
