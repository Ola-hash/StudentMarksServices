import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {ClassesModel} from "../models/classes.model";
import {SearchClassesRequestModel} from "../models/search-classes-request.model";
import {Observable} from "rxjs";
import {SearchClassesResultModel} from "../models/search-classes-result.model";
import {StudentClassesModel} from "../models/student-classes.model";

@Injectable()
export class ClassesService {
  constructor(private readonly httpClient: HttpClient) {
  }

  public createClasses(classesModel: ClassesModel) {
    return this.httpClient.post<void>('api/classes', classesModel);
  }

  public searchClasses(searchClassesRequestModel: SearchClassesRequestModel): Observable<SearchClassesResultModel[]> {
    return this.httpClient.post<SearchClassesResultModel[]>('api/classes/search', searchClassesRequestModel);
  }

  public createStudentClasses(studentClassesModel: StudentClassesModel): Observable<void> {
    return this.httpClient.post<void>("/api/studentClasses", studentClassesModel)
  }

  public getClassesByLecturerId(lecturerId: number): Observable<SearchClassesResultModel[]> {
    return this.httpClient.get<SearchClassesResultModel[]>("api/classes/" + lecturerId);
  }

  public getClassesDetails(classesId: number): Observable<SearchClassesResultModel> {
    return this.httpClient.get<SearchClassesResultModel>("api/classes/" + classesId + "/details");
  }

}
