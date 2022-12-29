import {Component, OnInit} from '@angular/core';
import {FormGroup} from "@angular/forms";
import {SubjectService} from "../../services/subject.service";
import {SubjectFormService} from "../../services/subject-form.service";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";
import {CourseService} from "../../services/course.service";
import {CourseFormService} from "../../services/course-form.service";

@Component({
  selector: 'app-create-course',
  templateUrl: './create-course.component.html',
  styleUrls: ['./create-course.component.scss']
})
export class CreateCourseComponent implements OnInit {

  public courseForm: FormGroup;

  constructor(private readonly courseService: CourseService,
              private readonly createCourseService: CourseFormService,
              private readonly toastrService: ToastrService,
              private readonly router: Router) {
  }

  ngOnInit(): void {
    this.courseForm = this.createCourseService.createForm()
  }

  public clickSaveSubject(): void {
    if (this.courseForm.valid) {
      this.createCourse();
    } else {
      this.courseForm.markAllAsTouched();
    }
  }

  private createCourse(): void {
    this.courseService.createCourse(this.courseForm.value)
      .subscribe({
        next: () => this.handleResponse(),
        error: (error) => this.toastrService.error(error)
      });
  }

  private handleResponse(): void {
    this.clearForm();
    this.toastrService.success("Pomyślnie dodano przedmiot")
  }

  public hasError(formControlName: string, error: string): boolean {
    return this.courseForm.controls[formControlName].hasError(error);
  }

  private clearForm(): void {
    this.courseForm.reset();
  }

}
