import { TestBed } from '@angular/core/testing';

import { ShiftScheduleService } from './shift-schedule.service';

describe('ShiftScheduleService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ShiftScheduleService = TestBed.get(ShiftScheduleService);
    expect(service).toBeTruthy();
  });
});
