import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {AuthService} from '../../services/auth.service';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  public loginForm: FormGroup;

  constructor(private readonly authService: AuthService,
              private readonly toastrService: ToastrService,
              private readonly router: Router) {
  }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      email: new FormControl(null, [Validators.required]),
      password: new FormControl(null, [Validators.required])
    })
  }

  public hasError(formControlName: string, error: string): boolean {
    return this.loginForm.controls[formControlName].hasError(error);
  }

  public clickLogin(): void {
    if (this.loginForm.invalid) {
      this.loginForm.markAllAsTouched();
    } else {
      this.authService.login(this.loginForm.value)
        .subscribe(() => this.router.navigate(["students-manage"]).then(),
          () => this.toastrService.error("Błędne dane logowania"))
    }
  }

}
