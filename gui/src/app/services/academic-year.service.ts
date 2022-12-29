import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {AcademicYearModel} from "../models/academic-year.model";
import {Observable} from "rxjs";

@Injectable()
export class AcademicYearService {
  constructor(private readonly httpClient: HttpClient) {
  }

  public createAcademicYear(academicYearModel: AcademicYearModel): Observable<void> {
    return this.httpClient.post<void>('api/semester', academicYearModel);
  }
}
