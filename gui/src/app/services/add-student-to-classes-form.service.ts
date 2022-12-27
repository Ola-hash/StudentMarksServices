import {Injectable} from "@angular/core";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Injectable()
export class AddStudentToClassesFormService {
  constructor() {
  }

  public createForm(subjectId: number): FormGroup {
    return new FormGroup({
      subjectId: new FormControl(subjectId, [Validators.required]),
      courseId: new FormControl(null, [Validators.required]),
      semesterId: new FormControl(null, [Validators.required])
    })
  }


}
