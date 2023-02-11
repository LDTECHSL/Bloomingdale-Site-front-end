import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DWomenComponent } from './d-women.component';

describe('DWomenComponent', () => {
  let component: DWomenComponent;
  let fixture: ComponentFixture<DWomenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DWomenComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DWomenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
