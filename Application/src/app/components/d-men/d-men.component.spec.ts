import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DMenComponent } from './d-men.component';

describe('DMenComponent', () => {
  let component: DMenComponent;
  let fixture: ComponentFixture<DMenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DMenComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DMenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
