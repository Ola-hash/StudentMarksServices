import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMarkToStudentComponent } from './add-mark-to-student.component';

describe('AddMarkToStudentComponent', () => {
  let component: AddMarkToStudentComponent;
  let fixture: ComponentFixture<AddMarkToStudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddMarkToStudentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddMarkToStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
