import { TestBed } from '@angular/core/testing';

import { ScheduledServicesService } from './scheduled-services.service';

describe('ScheduledServicesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ScheduledServicesService = TestBed.get(ScheduledServicesService);
    expect(service).toBeTruthy();
  });
});
