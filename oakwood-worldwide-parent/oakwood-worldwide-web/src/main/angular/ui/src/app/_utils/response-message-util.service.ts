import {Injectable} from '@angular/core';
import { ToastrService } from 'ngx-toastr';

@Injectable()
export class ResponseMessageUtilService {

  constructor(private toaster: ToastrService) {}

  displaySuccessMessage(successMessage: string): void {
    this.toaster.success(successMessage, 'Success!');
  }

  displayErrorMessage(error: any): void {
    if (error.error.fieldErrors) {
      this.toaster.error(error.error.fieldErrors.map(fe => {
        return '> ' + fe.message + '<br/>';
      }).join(''), 'Oops!', {enableHtml: true});
    } else if (error.error.message) {
      this.toaster.error(error.error.message, 'Oops!');
    }
  }

}
