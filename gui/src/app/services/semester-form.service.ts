import {Injectable} from "@angular/core";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Injectable()
export class SemesterFormService {
  constructor() {
  }

  public createForm(): FormGroup {
    return new FormGroup({
      year: new FormControl(undefined, [Validators.required]),
      type: new FormControl(undefined, [Validators.required])
    })

  }
}
