import { TestBed } from '@angular/core/testing';

import { ViewShiftsService } from './view-shifts.service';

describe('ViewShiftsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ViewShiftsService = TestBed.get(ViewShiftsService);
    expect(service).toBeTruthy();
  });
});
