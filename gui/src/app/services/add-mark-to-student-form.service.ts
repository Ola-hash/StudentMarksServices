import {Injectable} from "@angular/core";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Injectable()
export class AddMarkToStudentFormService {
  constructor() {
  }

  public createForm(studentId: number, classesId: number): FormGroup {
    return new FormGroup({
      studentId: new FormControl(studentId),
      classesId: new FormControl(classesId),
      value: new FormControl(null, [Validators.required]),
    })
  }
}
