import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DebitslipComponent } from './debitslip.component';

describe('DebitslipComponent', () => {
  let component: DebitslipComponent;
  let fixture: ComponentFixture<DebitslipComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DebitslipComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DebitslipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
