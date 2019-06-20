import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PortConfigService {
  port: number;
  constructor() {
    this.port = 8081;
   }

   getPort() {
     return this.port;
   }
}
