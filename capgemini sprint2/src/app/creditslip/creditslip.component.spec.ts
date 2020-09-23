import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreditslipComponent } from './creditslip.component';

describe('CreditslipComponent', () => {
  let component: CreditslipComponent;
  let fixture: ComponentFixture<CreditslipComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreditslipComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreditslipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
