import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {CourseModel} from "../models/course.model";
import {Observable} from "rxjs";

@Injectable()
export class CourseService {
  constructor(private readonly httpClient: HttpClient) {
  }

  public createCourse(courseModel: CourseModel): Observable<void> {
    return this.httpClient.post<void>('api/course', courseModel);
  }

  public getCourses(): Observable<CourseModel[]> {
    return this.httpClient.get<CourseModel[]>('api/courses')
  }
}
