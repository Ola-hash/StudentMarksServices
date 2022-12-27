import {Injectable} from "@angular/core";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Injectable()
export class LecturerFormService {
  constructor() {
  }

  public createForm(): FormGroup {
    return new FormGroup({
      firstName: new FormControl(null, [Validators.required]),
      lastName: new FormControl(null, [Validators.required]),
      email: new FormControl(null, [Validators.required])
    })
  }
}
