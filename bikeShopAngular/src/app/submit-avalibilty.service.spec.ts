import { TestBed } from '@angular/core/testing';

import { SubmitAvalibiltyService } from './submit-avalibilty.service';

describe('SubmitAvalibiltyService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SubmitAvalibiltyService = TestBed.get(SubmitAvalibiltyService);
    expect(service).toBeTruthy();
  });
});
