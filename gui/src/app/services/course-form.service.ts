import {Injectable} from "@angular/core";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Injectable()
export class CourseFormService {
  constructor() {
  }

  public createForm(): FormGroup {
    return new FormGroup({
      name: new FormControl(null, [Validators.required])
    })
  }
}
