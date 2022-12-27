import {Component, OnInit} from '@angular/core';
import {FormGroup} from "@angular/forms";
import {LecturerService} from "../../services/lecturer.service";
import {LecturerFormService} from "../../services/lecturer-form.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-create-lecturer',
  templateUrl: './create-lecturer.component.html',
  styleUrls: ['./create-lecturer.component.scss']
})
export class CreateLecturerComponent implements OnInit {
  public lectureForm: FormGroup;


  constructor(private readonly lecturerService: LecturerService,
              private readonly lecturerFormService: LecturerFormService,
              private readonly toastrService: ToastrService) {
  }

  ngOnInit(): void {
    this.lectureForm = this.lecturerFormService.createForm();
  }

  public clickSaveLecturer(): void {
    if (this.lectureForm.valid) {
      this.createLecturer();
    } else {
      this.lectureForm.markAllAsTouched();
    }
  }

  private createLecturer(): void {
    this.lecturerService.createLecturer(this.lectureForm.value)
      .subscribe({
        next: () => this.handleResponse(),
        error: (error) => this.toastrService.error(error)
      });
  }

  private handleResponse(): void {
    this.clearForm();
    this.toastrService.success("Pomyślnie dodano nauczyciela")
  }

  private clearForm(): void {
    this.lectureForm.reset();
  }


  public hasError(formControlName: string, error: string): boolean {
    return this.lectureForm.controls[formControlName].hasError(error);
  }

}
