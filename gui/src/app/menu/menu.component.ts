import {Component, OnInit} from '@angular/core';
import {UserDetailsService} from '../services/user-details.service';
import {UserDetailsModel} from '../models/user-details.model';
import {PrivilegeEnum} from '../models/privilege.model';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';
import {AuthService} from '../services/auth.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {
  public readonly allPrivileges = PrivilegeEnum;
  public userDetails: UserDetailsModel;
  public privileges: Set<string>;

  constructor(private readonly userDetailsService: UserDetailsService,
              private readonly toastrService: ToastrService,
              private readonly authService: AuthService,
              private readonly router: Router) {
  }

  ngOnInit(): void {
    this.userDetailsService.getUserDetails().subscribe(response => {
      this.userDetails = response;
      this.privileges = new Set(this.userDetails.privileges.map(privilege => privilege.name));
    }, error => {
      if (error.status === 403) {
        this.router.navigate(['login']).then(() => this.toastrService.error("Sesja wygasła"))
      } else {
        this.toastrService.error("Błąd serwera. Spróbuj później")
      }
    })
  }

  public hasPrivilege(privilege: string): boolean {
    return this.privileges ? this.privileges.has(privilege) : false;
  }

  public clickLogout(): void {
    this.authService.logout().subscribe(() => this.router.navigate(['login'])
        .then(() => this.toastrService.success("Pomyślnie wylogowano")),
      () => this.toastrService.error("Błąd serwera. Spróbuj później"))
  }

}
