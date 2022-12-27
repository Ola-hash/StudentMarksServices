import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {AcademicYearModel} from "../models/academic-year.model";
import {Observable} from "rxjs";
import {SemesterModel} from "../models/semester.model";

@Injectable()
export class SemesterService {
  constructor(private readonly httpClient: HttpClient) {
  }

  public createSemester(semesterModel: AcademicYearModel): Observable<void> {
    return this.httpClient.post<void>('api/semester', semesterModel);
  }

  public getSemesters(): Observable<SemesterModel[]> {
    return this.httpClient.get<SemesterModel[]>('api/semesters');
  }

}
