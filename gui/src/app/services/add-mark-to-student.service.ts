import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {MarkModel} from "../models/mark.model";

@Injectable()
export class AddMarkToStudentService {
  constructor(private readonly httpClient: HttpClient) {
  }

  public addMark(markModel: MarkModel): Observable<void> {
    return this.httpClient.post<void>('/api/mark', markModel);

  }
}
