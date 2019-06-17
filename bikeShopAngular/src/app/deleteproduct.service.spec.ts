import { TestBed } from '@angular/core/testing';

import { DeleteproductService } from './deleteproduct.service';

describe('DeleteproductService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DeleteproductService = TestBed.get(DeleteproductService);
    expect(service).toBeTruthy();
  });
});
