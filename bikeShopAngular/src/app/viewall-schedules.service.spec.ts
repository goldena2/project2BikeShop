import { TestBed } from '@angular/core/testing';

import { ViewallSchedulesService } from './viewall-schedules.service';

describe('ViewallSchedulesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ViewallSchedulesService = TestBed.get(ViewallSchedulesService);
    expect(service).toBeTruthy();
  });
});
