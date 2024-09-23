import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BomInventoryComponent } from './bom-inventory.component';

describe('BomInventoryComponent', () => {
  let component: BomInventoryComponent;
  let fixture: ComponentFixture<BomInventoryComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BomInventoryComponent]
    });
    fixture = TestBed.createComponent(BomInventoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
