import {Component, OnInit} from '@angular/core';
import {FormGroup} from "@angular/forms";
import {StudentService} from "../../services/student.service";
import {Router} from "@angular/router";
import {StudentFormService} from "../../services/student-form.service";
import {ToastrService} from "ngx-toastr";
import {SubjectService} from "../../services/subject.service";
import {SubjectModel} from "../../models/subject.model";

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.scss']
})
export class CreateStudentComponent implements OnInit {

  public studentForm: FormGroup;
  public subjectModels: SubjectModel[];


  constructor(private readonly studentService: StudentService,
              private readonly studentFormService: StudentFormService,
              private readonly toastrService: ToastrService,
              private readonly router: Router,
              private readonly subjectService: SubjectService) {
  }

  ngOnInit(): void {
    this.studentForm = this.studentFormService.createForm();
    this.subjectService.getSubjects().subscribe(response => this.subjectModels = response);

  }

  public clickSaveStudent(): void {
    if (this.studentForm.valid) {
      this.createStudent();
    } else {
      this.studentForm.markAllAsTouched();
    }
  }

  private createStudent(): void {
    this.studentService.createStudent(this.studentForm.value)
      .subscribe({
        next: () => this.handleResponse(),
        error: (error) => this.toastrService.error(error)
      });
  }

  private handleResponse(): void {
    this.clearForm();
    this.toastrService.success("Pomyślnie dodano studenta")
    this.navigate();
  }

  public hasError(formControlName: string, error: string): boolean {
    return this.studentForm.controls[formControlName].hasError(error);
  }

  private clearForm(): void {
    this.studentForm.reset();
  }

  public navigate() {
    this.router.navigate(['students-list']).then();
  }


}

