import { TestBed } from '@angular/core/testing';

import { AllSchedulesService } from './all-schedules.service';

describe('AllSchedulesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AllSchedulesService = TestBed.get(AllSchedulesService);
    expect(service).toBeTruthy();
  });
});
