import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreditchequeComponent } from './creditcheque.component';

describe('CreditchequeComponent', () => {
  let component: CreditchequeComponent;
  let fixture: ComponentFixture<CreditchequeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreditchequeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreditchequeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
