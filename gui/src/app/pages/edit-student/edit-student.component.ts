import {Component, OnInit} from '@angular/core';
import {FormGroup} from "@angular/forms";
import {StudentService} from "../../services/student.service";
import {StudentFormService} from "../../services/student-form.service";
import {ToastrService} from "ngx-toastr";
import {ActivatedRoute, Router} from "@angular/router";
import {StudentModel} from "../../models/student.model";
import {SubjectModel} from "../../models/subject.model";
import {SubjectService} from "../../services/subject.service";

@Component({
  selector: 'app-edit-student',
  templateUrl: './edit-student.component.html',
  styleUrls: ['./edit-student.component.scss']
})
export class EditStudentComponent implements OnInit {
  public id: number;
  public editForm: FormGroup;
  public subjectModel: SubjectModel;

  constructor(private readonly studentService: StudentService,
              private readonly studentFormService: StudentFormService,
              private readonly route: ActivatedRoute,
              private readonly router: Router,
              private readonly toastrService: ToastrService,
              private readonly subjectService: SubjectService) {
  }

  ngOnInit(): void {
    const idParam: string = this.route.snapshot.paramMap.get('id');
    if (idParam.match("^[\\d]+$")) {
      this.id = parseInt(idParam, 10);
      this.studentService.getStudentById(this.id).subscribe(response => {
        const studentModel = response;
        this.editForm = this.studentFormService.editForm(studentModel);
        this.subjectService.getSubjectById(studentModel.subjectId).subscribe(subjectResponse => {
          this.subjectModel = subjectResponse;
        }, error => this.router.navigate(["students-list"]).then(() => this.toastrService.error(error.error.message)));
      }, error => {
        this.router.navigate(["students-list"]).then(() => this.toastrService.error(error.error.message))

      });
    } else {
      this.router.navigate(["students-list"]).then(() => this.toastrService.error("Nieprawidłowy paramter id"))
    }
  }

  public editStudent() {
    if (this.editForm.valid) {
      this.studentService.editStudent(this.editForm.value, this.id).subscribe(() => {
        this.toastrService.success("Pomyślnie zedytowano studenta")
        this.navigate()
      }, error => this.toastrService.error(error.error.message))
    } else {
      this.editForm.markAllAsTouched();
    }

  }


  public hasError(formControlName: string, error: string): boolean {
    return this.editForm.controls[formControlName].hasError(error);
  }

  public navigate() {
    this.router.navigate(['students-list']).then();
  }

  public deleteStudent() {
    this.studentService.deleteStudent(this.id)
      .subscribe(() => this.router.navigate(['students-list']).then(() => this.toastrService.success("Pomyślnie usunięto studenta")),
        error => this.toastrService.error("Wystąpił błąd podczas usuwania studenta"));
  }

}
