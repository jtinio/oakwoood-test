import {Component, OnInit, Input} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {

  @Input('userForm')
  userForm: FormGroup;

  constructor(private toaster: ToastrService) {}

  ngOnInit() {
  }

  openFieldInformation(field: string) {
    this.toaster.info(this.generateFieldInformation(field), field, {enableHtml: true});
  }

  private generateFieldInformation(field: string): string {
    if (field === 'Username') {
      return 'Length should be between 5 and 35. Alphanumeric characters only.';
    } else if (field === 'Password') {
      return 'Must contain at least:<br>1 lowercase letter<br/>\
              1 uppercase letter<br/>1 number<br/>1 special character<br/>\
              length is between 5 and 20';
    } else if (field === 'Re-Enter Password') {
      return 'Must match the Password';
    } else if (field === 'First Name' || field === 'Last Name') {
      return 'Length should be between 2 and 35. Alphabet only.';
    }
    return null;
  }

}
