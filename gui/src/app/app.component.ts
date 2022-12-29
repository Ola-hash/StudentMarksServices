import {Component} from '@angular/core';
import {UserDetailsCacheService} from './services/user-details-cache.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent{

  constructor(private readonly userDetailsCacheService: UserDetailsCacheService) {
  }
}
