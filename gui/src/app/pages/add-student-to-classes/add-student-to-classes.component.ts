import {Component, OnInit} from '@angular/core';
import {FormGroup} from "@angular/forms";
import {SubjectModel} from "../../models/subject.model";
import {ClassesService} from "../../services/classes.service";
import {AddStudentToClassesFormService} from "../../services/add-student-to-classes-form.service";
import {ActivatedRoute, Router} from "@angular/router";
import {SubjectService} from "../../services/subject.service";
import {StudentService} from "../../services/student.service";
import {StudentModel} from "../../models/student.model";
import {CourseService} from "../../services/course.service";
import {CourseModel} from "../../models/course.model";
import {SemesterService} from "../../services/semester.service";
import {SemesterModel} from "../../models/semester.model";
import {ToastrService} from "ngx-toastr";
import {SearchClassesResultModel} from "../../models/search-classes-result.model";
import {StudentClassesModel} from "../../models/student-classes.model";

@Component({
  selector: 'app-add-student-to-classes',
  templateUrl: './add-student-to-classes.component.html',
  styleUrls: ['./add-student-to-classes.component.scss']
})
export class AddStudentToClassesComponent implements OnInit {

  public addStudentToClassesForm: FormGroup;
  public id: number;
  public subjectModel: SubjectModel;
  public studentModel: StudentModel;
  public courseModels: CourseModel[];
  public semesterModel: SemesterModel[];
  public searchClasses: SearchClassesResultModel[];
  displayedColumns: string[] = ['type', 'courseName', 'courseDate', 'lecturer', 'addStudent']

  constructor(private readonly classesService: ClassesService,
              private readonly addStudentToClassesFormService: AddStudentToClassesFormService,
              private readonly router: Router,
              private readonly route: ActivatedRoute,
              private readonly toastrService: ToastrService,
              private readonly courseService: CourseService,
              private readonly subjectService: SubjectService,
              private readonly studentService: StudentService,
              private readonly semesterService: SemesterService) {
  }

  ngOnInit(): void {
    const idParam: string = this.route.snapshot.paramMap.get('id');
    if (idParam.match("^[\\d]+$")) {
      this.id = parseInt(idParam, 10);
      this.studentService.getStudentById(this.id).subscribe(response => {
        this.studentModel = response;
        this.addStudentToClassesForm = this.addStudentToClassesFormService.createForm(this.studentModel.subjectId);
        this.subjectService.getSubjectById(this.studentModel.subjectId).subscribe(subjectResponse => {
          this.subjectModel = subjectResponse;
        }, error => this.toastrService.error(error.error.message));
      }, error => this.toastrService.error(error.error.message))
      this.courseService.getCourses().subscribe(response => {
        this.courseModels = response;
      }, error => this.toastrService.error(error.error.message))
      this.semesterService.getSemesters().subscribe(response => {
        this.semesterModel = response;
      }, error => this.toastrService.error(error.error.message))
    }
  }

  public clickSearchClasses(): void {
    if (this.addStudentToClassesForm.invalid) {
      this.addStudentToClassesForm.markAllAsTouched();
      return;
    }
    this.classesService.searchClasses(this.addStudentToClassesForm.value)
      .subscribe(response => {
        this.searchClasses = response;
      });
  }

  public clickCreateStudentClasses(classesId: number): void {
    const studentClasses: StudentClassesModel = {
      classesId: classesId,
      studentId: this.studentModel.studentId
    }
    this.classesService.createStudentClasses(studentClasses).subscribe(() => {
      this.toastrService.success("Pomyślnie przypisano studenta do zajęć")
    }, error => this.toastrService.error(error.error.message))
  }

  public hasError(formControlName: string, error: string): boolean {
    return this.addStudentToClassesForm.controls[formControlName].hasError(error);
  }

}
