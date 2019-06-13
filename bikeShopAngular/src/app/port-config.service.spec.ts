import { TestBed } from '@angular/core/testing';

import { PortConfigService } from './port-config.service';

describe('PortConfigService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PortConfigService = TestBed.get(PortConfigService);
    expect(service).toBeTruthy();
  });
});
