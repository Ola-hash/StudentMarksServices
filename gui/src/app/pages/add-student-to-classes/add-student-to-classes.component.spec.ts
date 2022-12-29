import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddStudentToClassesComponent } from './add-student-to-classes.component';

describe('AddStudentToClassesComponent', () => {
  let component: AddStudentToClassesComponent;
  let fixture: ComponentFixture<AddStudentToClassesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddStudentToClassesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddStudentToClassesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
