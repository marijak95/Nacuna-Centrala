import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthorsThesesComponent } from './authors-theses.component';

describe('AuthorsThesesComponent', () => {
  let component: AuthorsThesesComponent;
  let fixture: ComponentFixture<AuthorsThesesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuthorsThesesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthorsThesesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
