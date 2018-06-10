import {Injectable} from '@angular/core';
import {HttpHeaders} from '@angular/common/http';

@Injectable()
export class GlobalUtilService {

  private CONTENT_OAUTH2_HEADERS: HttpHeaders = new HttpHeaders({
    'Content-type': 'application/x-www-form-urlencoded; charset=utf-8',
    'Accept': 'application/json;',
    'Authorization': 'Basic ' + btoa('OakwoodWeb:OakwoodWorldwide')
  });
  OAUTH2_HEADER_REQUEST: any = {headers: this.CONTENT_OAUTH2_HEADERS};

  private CONTENT_JSON_HEADERS: HttpHeaders = new HttpHeaders().set('Content-Type', 'application/json');
  COMMON_JSON_HEADER_REQUEST: any = {headers: this.CONTENT_JSON_HEADERS};

  constructor() {}

}
