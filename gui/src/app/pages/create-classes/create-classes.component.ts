import {Component, OnInit} from '@angular/core';
import {FormGroup} from "@angular/forms";
import {ClassesService} from "../../services/classes.service";
import {ClassesFormService} from "../../services/classes-form.service";
import {ToastrService} from "ngx-toastr";
import {CourseModel} from "../../models/course.model";
import {LecturerModel} from "../../models/lecturer.model";
import {LecturerService} from "../../services/lecturer.service";
import {CourseService} from "../../services/course.service";
import {SemesterModel} from "../../models/semester.model";
import {SemesterService} from "../../services/semester.service";
import {SubjectModel} from "../../models/subject.model";
import {SubjectService} from "../../services/subject.service";

@Component({
  selector: 'app-create-classes',
  templateUrl: './create-classes.component.html',
  styleUrls: ['./create-classes.component.scss']
})
export class CreateClassesComponent implements OnInit {
  public classesForm: FormGroup;
  public coursesModels: CourseModel[];
  public lecturerModels: LecturerModel[];
  public semesterModels: SemesterModel[];
  public subjectModels: SubjectModel[];

  public classTypes: string[] = ["Laboratorium", 'Wykład', 'Ćwiczenia', 'Seminarium'];


  constructor(private readonly classesService: ClassesService,
              private readonly classesFormService: ClassesFormService,
              private readonly toastrService: ToastrService,
              private readonly lecturerService: LecturerService,
              private readonly courseService: CourseService,
              private readonly semesterService: SemesterService,
              private readonly subjectService: SubjectService) {
  }

  ngOnInit(): void {
    this.classesForm = this.classesFormService.createForm();
    this.lecturerService.getLecturer().subscribe(response => this.lecturerModels = response);
    this.courseService.getCourses().subscribe(response => this.coursesModels = response);
    this.semesterService.getSemesters().subscribe(response => this.semesterModels = response);
    this.subjectService.getSubjects().subscribe(response => this.subjectModels = response);
  }

  private createClasses(): void {
    this.classesService.createClasses(this.classesForm.value).subscribe({
      next: () => this.handleResponse(),
      error: (error) => this.toastrService.error(error)
    });

  }

  public clickSaveClasses(): void {
    if (this.classesForm.valid) {
      this.createClasses();
    } else {
      this.classesForm.markAllAsTouched();
    }
  }

  private handleResponse(): void {
    this.clearForm();
    this.toastrService.success("Pomyślnie dodano grupę zajęciową")
  }


  public hasError(formControlName: string, error: string): boolean {
    return this.classesForm.controls[formControlName].hasError(error);
  }

  private clearForm(): void {
    this.classesForm.reset();
  }


}
