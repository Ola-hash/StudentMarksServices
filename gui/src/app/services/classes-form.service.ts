import {Injectable} from "@angular/core";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Injectable()

export class ClassesFormService {
  constructor() {
  }

  public createForm(): FormGroup {
    return new FormGroup({
      type: new FormControl(null, [Validators.required]),
      code: new FormControl(null, [Validators.required]),
      classesDate: new FormControl(null, [Validators.required]),
      classesRoom: new FormControl(null, [Validators.required]),
      lecturerId: new FormControl(null, [Validators.required]),
      semesterId: new FormControl(null, [Validators.required]),
      courseId: new FormControl(null, [Validators.required]),
      subjectId: new FormControl(null, [Validators.required])
    })
  }

}
