import { TestBed } from '@angular/core/testing';

import { MakePurchaseService } from './make-purchase.service';

describe('MakePurchaseService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MakePurchaseService = TestBed.get(MakePurchaseService);
    expect(service).toBeTruthy();
  });
});
