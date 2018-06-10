import {UserApiService} from '../../../_services/api/user-api.service';
import {ResponseMessageUtilService} from '../../../_utils/response-message-util.service';
import {Component, OnInit} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {Ng4LoadingSpinnerService} from 'ng4-loading-spinner';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-user-creation',
  templateUrl: './user-creation.component.html',
  styleUrls: ['./user-creation.component.css']
})
export class UserCreationComponent implements OnInit {

  userForm: FormGroup;

  constructor(private userApiService: UserApiService, private router: Router,
    private formBuilder: FormBuilder, private toaster: ToastrService,
    private spinnerService: Ng4LoadingSpinnerService,
    private responseMessageUtilService: ResponseMessageUtilService) {}

  ngOnInit() {
    this.userForm = this.formBuilder.group({
      'username': ['', Validators.compose([Validators.required, Validators.minLength(5), Validators.maxLength(35)])],
      'password': ['', Validators.compose([Validators.required, Validators.minLength(8), Validators.maxLength(20)])],
      'matchingPassword': ['', Validators.compose([Validators.required, Validators.minLength(8), Validators.maxLength(20)])],
      'firstName': ['', Validators.compose([Validators.required, Validators.minLength(2),
      Validators.maxLength(35), Validators.pattern('[a-zA-Z][a-zA-Z ]+')])],
      'lastName': ['', Validators.compose([Validators.required, Validators.minLength(2),
      Validators.maxLength(35), Validators.pattern('[a-zA-Z][a-zA-Z ]+')])],
      'email': ['', Validators.compose([Validators.required, Validators.pattern(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)])]
    });
  }

  onSubmit() {
    if (this.userForm.valid) {
      this.spinnerService.show();
      this.userApiService.createUser(this.userForm.value)
        .subscribe(result => {
          this.toaster.success('User successfully created!', 'Success!');
          this.spinnerService.hide();
          this.router.navigate(['userManagement']);
        }, error => {
          this.spinnerService.hide();
          this.responseMessageUtilService.displayErrorMessage(error);
        });
    }
  }

}
