import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VeiwTransactionsComponent } from './veiw-transactions.component';

describe('VeiwTransactionsComponent', () => {
  let component: VeiwTransactionsComponent;
  let fixture: ComponentFixture<VeiwTransactionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VeiwTransactionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VeiwTransactionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
