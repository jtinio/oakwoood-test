import {UserApiService} from '../../_services/api/user-api.service';
import {UserDatasource} from './user-datasource';
import {Component, OnInit, OnDestroy, ViewChild, Input, ElementRef} from '@angular/core';
import {DataSource} from '@angular/cdk/collections';
import {MatPaginator, MatSort} from '@angular/material';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/observable/merge';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/takeWhile';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
import 'rxjs/add/observable/fromEvent';
import {Router} from '@angular/router';

@Component({
  selector: 'app-user-datatable',
  templateUrl: './user-datatable.component.html',
  styleUrls: ['./user-datatable.component.css']
})
export class UserDatatableComponent implements OnInit, OnDestroy {

  alive: boolean;
  currentDirection = 'asc';
  currentPageSize = 10;
  displayedColumns = ['id', 'firstName', 'lastName', 'email', 'action'];
  dataSource: UserDatasource | null;

  private _search = new BehaviorSubject('');
  get search(): string {return this._search.value; }
  set search(filter: string) {this._search.next(filter); }

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild('filter') filter: ElementRef;

  constructor(private router: Router, private userApiService: UserApiService) {}

  ngOnInit() {
    this.alive = true;
    this.paginator.pageSize = 10;
    this.sort.sort({id: 'id', start: 'asc', disableClear: false});
    Observable.fromEvent(this.filter.nativeElement, 'keyup')
      .takeWhile(() => this.alive)
      .debounceTime(150)
      .distinctUntilChanged()
      .subscribe(() => {
        if (!this.dataSource) {return; }
        this.search = this.filter.nativeElement.value;
      });
    this.watchChanges();
  }

  ngOnDestroy(): void {
    this.alive = false;
  }

  private watchChanges(): void {
    const displayDataChanges = [this._search, this.paginator.page, this.sort.sortChange];
    Observable.merge(...displayDataChanges)
      .takeWhile(() => this.alive)
      .subscribe(() => this.query());
  }

  private query(): void {
    this.userApiService.getUserManagementDataSource(
      this.paginator.pageIndex, this.paginator.pageSize,
      this.sort.direction, this.sort.active, this.search.toLowerCase())
      .takeWhile(() => this.alive)
      .subscribe(result => {
        const r: any = result;
        this.paginator.length = r.totalElements;
        this.dataSource = new UserDatasource(r.content);
      }, error => {
        console.log(error);
        this.dataSource = new UserDatasource([]);
      });
  }

  onViewClick(row: any): void {
    this.router.navigate(['/users/details/', row.id]);
  }

}

