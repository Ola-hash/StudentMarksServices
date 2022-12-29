import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassesStudentListComponent } from './classes-student-list.component';

describe('ClassesStudentListComponent', () => {
  let component: ClassesStudentListComponent;
  let fixture: ComponentFixture<ClassesStudentListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClassesStudentListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClassesStudentListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
