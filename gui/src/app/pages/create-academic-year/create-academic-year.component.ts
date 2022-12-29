import {Component, OnInit} from '@angular/core';
import {FormGroup} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {AcademicYearService} from "../../services/academic-year.service";
import {AcademicYearFormService} from "../../services/academic-year-form-service";

@Component({
  selector: 'app-create-academic-year',
  templateUrl: './create-academic-year.component.html',
  styleUrls: ['./create-academic-year.component.scss']
})
export class CreateAcademicYearComponent implements OnInit {
  public academicForm: FormGroup;

  constructor(private readonly academicYearService: AcademicYearService,
              private readonly createAcademicYearService: AcademicYearFormService,
              private readonly toastrService: ToastrService) {
  }


  ngOnInit(): void {
    this.academicForm = this.createAcademicYearService.createForm()
  }

  public clickSaveAcademicYear(): void {
    if (this.academicForm.valid) {
      this.createAcademicYear();
    } else {
      this.academicForm.markAllAsTouched();
    }
  }

  private createAcademicYear(): void {
    this.academicYearService.createAcademicYear(this.academicForm.value)
      .subscribe({
        next: () => this.handleResponse(),
        error: (error) => this.toastrService.error(error)
      })
  }

  private handleResponse(): void {
    this.clearForm();
    this.toastrService.success("Pomyślnie dodano rok akademicki")
  }

  public hasError(formControlName: string, error: string): boolean {
    return this.academicForm.controls[formControlName].hasError(error);
  }

  private clearForm(): void {
    this.academicForm.reset();
  }
}
