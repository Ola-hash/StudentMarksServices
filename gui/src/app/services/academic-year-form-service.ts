import {Injectable} from "@angular/core";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {min} from "rxjs";

@Injectable()
export class AcademicYearFormService {
  constructor() {
  }


  public createForm(): FormGroup {
    const date = new Date();
    const year = date.getFullYear();

    return new FormGroup({
      startYear: new FormControl(undefined, [Validators.required, Validators.min(year)]),
      endYear: new FormControl(undefined, [Validators.required, Validators.min(year + 1)])
    })

  }
}
