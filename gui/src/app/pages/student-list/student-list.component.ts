import {Component, OnInit} from '@angular/core';
import {SearchStudentsResult, StudentModel} from "../../models/student.model";
import {StudentService} from "../../services/student.service";
import {Router} from "@angular/router";
import {SearchStudentRequestModel} from "../../models/search-student-request.model";
import {FormGroup} from "@angular/forms";
import {StudentListFormService} from "../../services/student-list-form.service";
import {SubjectModel} from "../../models/subject.model";
import {publish} from "rxjs";
import {ToastrService} from "ngx-toastr";
import {SearchStudentResultModel} from "../../models/search-student-result.model";
import {SubjectService} from "../../services/subject.service";

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.scss']
})
export class StudentListComponent implements OnInit {
  public studentsForm: FormGroup;
  public searchStudentResultModels: SearchStudentResultModel[];
  public subjectModels: SubjectModel[];
  displayedColumns: string[] = ['index', 'firstName', 'lastName', 'email', 'subjectName', 'addClasses'];

  constructor(private readonly studentService: StudentService,
              private readonly toastrService: ToastrService,
              private readonly studentListFormService: StudentListFormService,
              private readonly subjectService: SubjectService,
              private readonly router: Router) {
  }

  ngOnInit(): void {
    this.studentsForm = this.studentListFormService.createForm();
    this.searchStudents();
    this.subjectService.getSubjects().subscribe(response => this.subjectModels = response);
  }

  public click(): void {
    this.searchStudents();
  }

  private searchStudents(): void {
    this.studentService.searchStudents(this.studentsForm.value).subscribe(response => this.searchStudentResultModels = response,
      error => this.toastrService.error("Błąd przy wyszukiwaniu studentów"));
  }

  public navigateAddStudentToClasses(studentId: number) {
    this.router.navigate(['add-student-to-classes/', studentId]).then();
  }
}
