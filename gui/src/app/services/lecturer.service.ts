import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {PersonalDataModel} from "../models/personal-data.model";
import {Observable} from "rxjs";
import {LecturerModel} from "../models/lecturer.model";

@Injectable()
export class LecturerService {

  constructor(private readonly httpClient: HttpClient) {
  }

  public createLecturer(personalDataModel: PersonalDataModel): Observable<void> {
    return this.httpClient.post<void>('api/lecturer', personalDataModel);
  }

  public getLecturer(): Observable<LecturerModel[]> {
    return this.httpClient.get<LecturerModel[]>('api/lectures')
  }
}
