import { TestBed } from '@angular/core/testing';

import { MakeAccountService } from './make-account.service';

describe('MakeAccountService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MakeAccountService = TestBed.get(MakeAccountService);
    expect(service).toBeTruthy();
  });
});
