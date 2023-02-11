import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DAllComponent } from './d-all.component';

describe('DAllComponent', () => {
  let component: DAllComponent;
  let fixture: ComponentFixture<DAllComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DAllComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
