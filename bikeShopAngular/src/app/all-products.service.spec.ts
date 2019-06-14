import { TestBed } from '@angular/core/testing';

import { AllProductsService } from './all-products.service';

describe('AllProductsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AllProductsService = TestBed.get(AllProductsService);
    expect(service).toBeTruthy();
  });
});
