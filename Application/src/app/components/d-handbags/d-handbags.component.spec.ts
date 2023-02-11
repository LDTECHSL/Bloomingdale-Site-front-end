import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DHandbagsComponent } from './d-handbags.component';

describe('DHandbagsComponent', () => {
  let component: DHandbagsComponent;
  let fixture: ComponentFixture<DHandbagsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DHandbagsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DHandbagsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
