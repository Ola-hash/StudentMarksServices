import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ClassesService} from "../../services/classes.service";
import {StudentService} from "../../services/student.service";
import {ToastrService} from "ngx-toastr";
import {StudentModel} from "../../models/student.model";
import {FormGroup} from "@angular/forms";
import {AddMarkToStudentService} from "../../services/add-mark-to-student.service";
import {MarkModel} from "../../models/mark.model";
import {AddMarkToStudentFormService} from "../../services/add-mark-to-student-form.service";

@Component({
  selector: 'app-add-mark-to-student',
  templateUrl: './add-mark-to-student.component.html',
  styleUrls: ['./add-mark-to-student.component.scss']
})
export class AddMarkToStudentComponent implements OnInit {

  public studentId: number;
  public classesId: number;
  public studentModel: StudentModel;
  public addMarkToStudentForm: FormGroup;
  public markModel: MarkModel;

  constructor(private readonly router: Router,
              private readonly route: ActivatedRoute,
              private readonly addMarkToStudentFormService: AddMarkToStudentFormService,
              private readonly classesService: ClassesService,
              private readonly studentService: StudentService,
              private readonly toastrService: ToastrService,
              private readonly addMarkToStudentService: AddMarkToStudentService) {
  }


  ngOnInit(): void {
    const studentIdParam: string = this.route.snapshot.paramMap.get('studentId');
    const classesIdParam: string = this.route.snapshot.paramMap.get('classesId');

    if (studentIdParam.match("^[\\d]+$") && classesIdParam.match("^[\\d]+$")) {
      this.studentId = parseInt(studentIdParam, 10);
      this.classesId = parseInt(classesIdParam, 10);
      this.studentService.getStudentById(this.studentId).subscribe(response => this.studentModel = response);
      this.addMarkToStudentForm = this.addMarkToStudentFormService.createForm(this.studentId, this.classesId);
    } else {
      this.toastrService.error("Błędny parametr")
    }
  }

  private handleResponse(): void {
    this.clearForm();
    this.toastrService.success("Pomyślnie dodano ocenę")
  }

  public addMark(): void {
    if (this.addMarkToStudentForm.invalid) {
      this.addMarkToStudentForm.markAllAsTouched()
    } else {
      this.addMarkToStudentService.addMark(this.addMarkToStudentForm.value)
        .subscribe({
          next: () => this.handleResponse(),
          error: (error) => this.toastrService.error(error)
        });
    }

  }

  private clearForm(): void {
    this.addMarkToStudentForm.reset();
  }

  public navigate(lecturerId: number) {
    this.router.navigate(['classes-student-list/' + lecturerId]).then();
  }

}
