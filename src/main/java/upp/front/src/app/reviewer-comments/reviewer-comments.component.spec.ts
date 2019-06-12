import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReviewerCommentsComponent } from './reviewer-comments.component';

describe('ReviewerCommentsComponent', () => {
  let component: ReviewerCommentsComponent;
  let fixture: ComponentFixture<ReviewerCommentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReviewerCommentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReviewerCommentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
