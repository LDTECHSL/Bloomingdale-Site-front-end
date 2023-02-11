import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DKidsComponent } from './d-kids.component';

describe('DKidsComponent', () => {
  let component: DKidsComponent;
  let fixture: ComponentFixture<DKidsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DKidsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DKidsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
