import {AuthenticationService} from './_services/authentication.service';
import {Component, ViewContainerRef} from '@angular/core';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'app';
  isLoggedIn$: Observable<boolean>;
  menuShowPermission: any = {};

  constructor(private authenticationService: AuthenticationService,
    public toastr: ToastrService, private router: Router) {
    this.authenticationService.logout();
    this.isLoggedIn$ = this.authenticationService.isLoggedInObservable();
    this.subscribeToUserLoggedIn();
  }

  subscribeToUserLoggedIn(): void {
    this.isLoggedIn$.subscribe(result => {
      if (result) {
        setTimeout(() => {
          this.generateMenuPermissionObject();
        });
      } else {
        this.menuShowPermission = {};
      }
    });
  }

  private generateMenuPermissionObject(): void {
    this.authenticationService.getPermissions().forEach(p => {
      if (p === 'READ_PERMISSION') {
        this.menuShowPermission.userManagementMenuShow = true;
      }
    });
  }

}
