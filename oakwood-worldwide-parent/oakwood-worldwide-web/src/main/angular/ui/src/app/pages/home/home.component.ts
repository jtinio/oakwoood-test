import {UserApiService} from '../../_services/api/user-api.service';
import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private userApiService: UserApiService) {}

  ngOnInit() {
    this.userApiService.getAllUsers()
      .subscribe(result => {
        console.log(result);
      }, error => {
        console.log(error);
      });
  }

}
