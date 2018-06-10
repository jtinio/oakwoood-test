import {Injectable} from '@angular/core';
import {Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot} from '@angular/router';
import {AuthenticationService} from '../_services/authentication.service';

@Injectable()
export class RoleGuard implements CanActivate {

  constructor(private router: Router, private authService: AuthenticationService) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    // this will be passed from the route config on the data property
    const expectedRoles = route.data.expectedRoles;
    const userPermissions = this.authService.getPermissions();
    if (this.authService.isAuthenticated() && expectedRoles.some(r => userPermissions.includes(r))) {
      return true;
    }
    this.router.navigate(['/login']);
    return false;
  }

}
