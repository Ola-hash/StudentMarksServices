import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {SubjectModel} from "../models/subject.model";
import {Observable} from "rxjs";

@Injectable()
export class SubjectService {
  constructor(private readonly httpClient: HttpClient) {
  }

  public createSubject(subjectModel: SubjectModel): Observable<void> {
    return this.httpClient.post<void>('api/subject', subjectModel)
  }

  public getSubjects(): Observable<SubjectModel[]> {
    return this.httpClient.get<SubjectModel[]>('api/subjects')
  }

  public getSubjectById(id: number): Observable<SubjectModel> {
    return this.httpClient.get<SubjectModel>('api/subjects/' + id);
  }


}
