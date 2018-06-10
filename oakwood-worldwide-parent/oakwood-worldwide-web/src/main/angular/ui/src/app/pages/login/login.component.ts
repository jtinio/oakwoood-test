import {AuthenticationService} from '../../_services/authentication.service';
import {Component, OnInit, AfterViewInit} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {Ng4LoadingSpinnerService} from 'ng4-loading-spinner';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, AfterViewInit {

  loginForm: FormGroup;

  constructor(private authenticationService: AuthenticationService,
    private toaster: ToastrService, private formBuilder: FormBuilder,
    private spinnerService: Ng4LoadingSpinnerService, private router: Router) {
  }

  ngAfterViewInit() {
    this.authenticationService.logout();
  }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      'username': ['', Validators.compose([Validators.required, Validators.minLength(5), Validators.maxLength(35)])],
      'password': ['', Validators.compose([Validators.required, Validators.minLength(5), Validators.maxLength(20)])]
    });
  }

  login(): void {
    if (this.loginForm.valid) {
      this.spinnerService.show();
      this.authenticationService.obtainAccessToken(this.loginForm.value)
        .subscribe(result => {
          this.spinnerService.hide();
          this.router.navigate(['home']);
        }, error => {
          this.spinnerService.hide();
          this.toaster.error('Invalid username and/or password', 'Oops!');
        });
    }
  }

}
