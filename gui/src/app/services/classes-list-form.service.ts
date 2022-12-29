import {Injectable} from "@angular/core";
import {FormControl, FormGroup} from "@angular/forms";

@Injectable()
export class ClassesListFormService {
  constructor() {
  }

  public createForm(): FormGroup {
    return new FormGroup({
      subjectId: new FormControl(null),
      courseId: new FormControl(null),
      semesterId: new FormControl(null),
      type: new FormControl(null),
    })
  }
}
