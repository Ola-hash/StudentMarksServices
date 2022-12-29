import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {UserDetailsModel} from '../models/user-details.model';

@Injectable()
export class UserDetailsService {
  constructor(private readonly httpClient: HttpClient) {
  }

  public getUserDetails(): Observable<UserDetailsModel> {
    return this.httpClient.get<UserDetailsModel>('api/userDetails')
  }
}
