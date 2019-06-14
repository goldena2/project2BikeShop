import { TestBed } from '@angular/core/testing';

import { MyServivesService } from './my-servives.service';

describe('MyServivesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MyServivesService = TestBed.get(MyServivesService);
    expect(service).toBeTruthy();
  });
});
