import {Injectable} from "@angular/core";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {StudentModel} from "../models/student.model";

@Injectable()
export class StudentFormService {
  constructor() {
  }

  public createForm(): FormGroup {
    return new FormGroup({
      firstName: new FormControl(null, [Validators.required]),
      lastName: new FormControl(null, [Validators.required]),
      email: new FormControl(null, [Validators.required, Validators.pattern("^[A-Za-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]),
      subjectId: new FormControl(null, [Validators.required])
    })
  }

  public editForm(studentModel: StudentModel): FormGroup {
    return new FormGroup({
      studentId: new FormControl(studentModel.studentId),
      firstName: new FormControl(studentModel.firstName, [Validators.required]),
      lastName: new FormControl(studentModel.lastName, [Validators.required]),
      email: new FormControl(studentModel.email, [Validators.required, Validators.pattern("^[A-Za-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]),
      subjectId: new FormControl(studentModel.subjectId),
    })

  }
}
