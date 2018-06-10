import {environment} from '../../environments/environment';
import {LoginCredentials} from '../_models/login-credentials';
import {GlobalUtilService} from '../_utils/global-util.service';
import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import {Observable, BehaviorSubject} from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private loggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  constructor(private http: HttpClient, private globals: GlobalUtilService,
    private jwtHelperService: JwtHelperService) {
  }

  obtainAccessToken(loginCredentials: LoginCredentials): Observable<boolean> {
    const params = new URLSearchParams();
    params.append('username', loginCredentials.username);
    params.append('password', loginCredentials.password);
    params.append('grant_type', 'password');
    params.append('client_id', 'OakwoodWeb');

    return this.http.post(environment.API_URL + '/oauth/token', params.toString(), this.globals.OAUTH2_HEADER_REQUEST)
      .pipe(map(response => this.onAuthenticationResponse(response)));
  }

  private onAuthenticationResponse(response: any): boolean {
    if (response && response.access_token) {
      localStorage.setItem('token', response.access_token);
      localStorage.setItem('refresh_token', response.refresh_token);
      const tokenPayload = this.jwtHelperService.decodeToken(response.access_token);
      localStorage.setItem('permissions', tokenPayload.authorities);
      this.loggedIn.next(true);
      return true;
    }
    return false;
  }

  getToken(): string {
    return localStorage.getItem('token');
  }

  getPermissions(): Array<string> {
    const permissions: string = localStorage.getItem('permissions');
    return (permissions) ? permissions.split(',') : [];
  }

  isAuthenticated(): boolean {
    return !this.jwtHelperService.isTokenExpired();
  }

  isLoggedInObservable(): Observable<boolean> {
    return this.loggedIn.asObservable();
  }

  logout(): void {
    localStorage.clear();
    this.loggedIn.next(false);
  }
}
