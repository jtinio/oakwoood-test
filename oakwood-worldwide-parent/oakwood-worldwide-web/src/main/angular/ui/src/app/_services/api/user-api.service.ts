import {environment} from '../../../environments/environment';
import {UserRegistration} from '../../_models/user-registration';
import {GlobalUtilService} from '../../_utils/global-util.service';
import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserApiService {

  constructor(private http: HttpClient, private globals: GlobalUtilService) {}

  getCurrentUserInfo() {
    return this.http.get(environment.API_URL + '/users/info', this.globals.COMMON_JSON_HEADER_REQUEST);
  }

  getUserById(id: number) {
    return this.http.get(environment.API_URL + '/users/' + id, this.globals.COMMON_JSON_HEADER_REQUEST);
  }

  getAllUsers() {
    return this.http.get(environment.API_URL + '/users', this.globals.COMMON_JSON_HEADER_REQUEST);
  }

  createUser(userRegistration: UserRegistration) {
    return this.http.post(environment.API_URL + '/users', JSON.stringify(userRegistration),
      this.globals.COMMON_JSON_HEADER_REQUEST);
  }

  getUserManagementDataSource(pageNumber: number, size: number, direction: string, sort: any, search: string) {
    return this.http.get(environment.API_URL + '/users/datasource'
      + '?page=' + pageNumber + '&size=' + size + '&sort=' + sort + ',' + direction + '&search=' + search,
      this.globals.COMMON_JSON_HEADER_REQUEST);
  }
}
