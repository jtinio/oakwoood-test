import {AuthenticationService} from '../../_services/authentication.service';
import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-toolbar-menu',
  templateUrl: './toolbar-menu.component.html',
  styleUrls: ['./toolbar-menu.component.css']
})
export class ToolbarMenuComponent implements OnInit {

  constructor(private authenticationService: AuthenticationService,
    private router: Router) {}

  ngOnInit() {
  }

   onLogout(): void {
    this.authenticationService.logout();
    this.router.navigate(['login']);
  }
}
