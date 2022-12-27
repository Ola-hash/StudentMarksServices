import {Injectable} from "@angular/core";
import {FormControl, FormGroup} from "@angular/forms";

@Injectable()
export class StudentListFormService {
  constructor() {
  }

  public createForm(): FormGroup {
    return new FormGroup({
      index: new FormControl(null),
      lastName: new FormControl(null),
      subjectId: new FormControl(null),
      classesName: new FormControl(null),
      courseName: new FormControl(null),
    })
  }
}
