import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DebitchequeComponent } from './debitcheque.component';

describe('DebitchequeComponent', () => {
  let component: DebitchequeComponent;
  let fixture: ComponentFixture<DebitchequeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DebitchequeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DebitchequeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
