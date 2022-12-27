import {Component, OnInit} from '@angular/core';
import {SubjectService} from "../../services/subject.service";
import {FormGroup} from "@angular/forms";
import {SubjectFormService} from "../../services/subject-form.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-create-subject',
  templateUrl: './create-subject.component.html',
  styleUrls: ['./create-subject.component.scss']
})
export class CreateSubjectComponent implements OnInit {
  id: number;
  public subjectForm: FormGroup;

  constructor(private readonly subjectService: SubjectService,
              private readonly createSubjectService: SubjectFormService,
              private readonly toastrService: ToastrService) {
  }

  ngOnInit(): void {
    this.subjectForm = this.createSubjectService.createForm()
  }

  public clickSaveSubject(): void {
    if (this.subjectForm.valid) {
      this.createSubject();
    } else {
      this.subjectForm.markAllAsTouched();
    }
  }

  private createSubject(): void {
    this.subjectService.createSubject(this.subjectForm.value)
      .subscribe({
        next: () => this.handleResponse(),
        error: (error) => this.toastrService.error(error)
      });
  }

  private handleResponse(): void {
    this.clearForm();
    this.toastrService.success("Pomyślnie dodano kierunek studiów")
  }

  public hasError(formControlName: string, error: string): boolean {
    return this.subjectForm.controls[formControlName].hasError(error);
  }

  private clearForm(): void {
    this.subjectForm.reset();
  }



}
