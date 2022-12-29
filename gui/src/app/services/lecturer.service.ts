import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CreateLecturerModel, LecturerModel} from "../models/lecturer.model";

@Injectable()
export class LecturerService {

  constructor(private readonly httpClient: HttpClient) {
  }

  public createLecturer(createLecturerModel: CreateLecturerModel): Observable<void> {
    return this.httpClient.post<void>('api/lecturer', createLecturerModel);
  }

  public getLecturer(): Observable<LecturerModel[]> {
    return this.httpClient.get<LecturerModel[]>('api/lectures')
  }
}
