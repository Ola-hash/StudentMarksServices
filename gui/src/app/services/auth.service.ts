import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {LoginModel} from '../models/login.model';
import {Observable} from 'rxjs';

@Injectable()
export class AuthService {
  constructor(private readonly httpClient: HttpClient) {
  }

  public login(loginModel: LoginModel): Observable<void> {
    return this.httpClient.post<void>('api/login', loginModel);
  }

  public logout(): Observable<void> {
    return this.httpClient.post<void>('api/logout', {});
  }
}
