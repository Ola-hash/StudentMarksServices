import {Injectable} from '@angular/core';
import {UserDetailsService} from './user-details.service';
import {Observable, Subject, take} from 'rxjs';
import {UserDetailsModel} from '../models/user-details.model';

@Injectable()
export class UserDetailsCacheService {
  private userDetails$: Observable<UserDetailsModel>;

  constructor(private readonly userDetailsService: UserDetailsService) {
  }

  public loadUserDetails(): Observable<UserDetailsModel> {
    if (!this.userDetails$) {
      this.userDetails$ = this.userDetailsService.getUserDetails()
        .pipe(take(1))
    }
    return this.userDetails$;
  }

  public clearCache(): void {
    this.userDetails$ = new Subject();
  }
}
