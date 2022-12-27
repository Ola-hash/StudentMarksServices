import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {PersonalDataModel} from "../models/personal-data.model";
import {Observable} from "rxjs";
import {StudentModel} from "../models/student.model";
import {SearchStudentRequestModel} from "../models/search-student-request.model";
import {SearchStudentResultModel} from "../models/search-student-result.model";

@Injectable()
export class StudentService {
  constructor(private readonly httpClient: HttpClient) {
  }

  public createStudent(personalDataModel: PersonalDataModel): Observable<void> {
    return this.httpClient.post<void>('api/students', personalDataModel);
  }

  public getStudents(): Observable<StudentModel[]> {
    return this.httpClient.get<StudentModel[]>('api/students');
  }

  public getStudentById(id: number): Observable<StudentModel> {
    return this.httpClient.get<StudentModel>('api/students/' + id);
  }

  public searchStudents(searchStudentRequestModel: SearchStudentRequestModel): Observable<SearchStudentResultModel[]> {
    return this.httpClient.post<SearchStudentResultModel[]>('api/students/search', searchStudentRequestModel);
  }

  public deleteStudent(id: number): Observable<void> {
    return this.httpClient.delete<void>('api/student/' + id);
  }

  public editStudent(studentModel: StudentModel, id: number): Observable<void> {
    return this.httpClient.put<void>('api/students/' + id, studentModel);
  }

  public getStudentsByClassesId(classesId: number): Observable<StudentModel[]> {
    return this.httpClient.get<StudentModel[]>('api/students/' + classesId + '/classes')
  }

}
