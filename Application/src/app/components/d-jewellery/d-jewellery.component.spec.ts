import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DJewelleryComponent } from './d-jewellery.component';

describe('DJewelleryComponent', () => {
  let component: DJewelleryComponent;
  let fixture: ComponentFixture<DJewelleryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DJewelleryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DJewelleryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
