import { AuthenticationService } from '../../_services/authentication.service';
import {Component} from '@angular/core';
import {BreakpointObserver, Breakpoints, BreakpointState} from '@angular/cdk/layout';
import { Router } from '@angular/router';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
    map(result => result.matches)
    );

  constructor(private breakpointObserver: BreakpointObserver,
    private authenticationService: AuthenticationService,
    private router: Router) {}

  onLogout(): void {
    this.authenticationService.logout();
    this.router.navigate(['login']);
  }
}
