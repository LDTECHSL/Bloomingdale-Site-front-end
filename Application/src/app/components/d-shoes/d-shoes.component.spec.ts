import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DShoesComponent } from './d-shoes.component';

describe('DShoesComponent', () => {
  let component: DShoesComponent;
  let fixture: ComponentFixture<DShoesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DShoesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DShoesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
