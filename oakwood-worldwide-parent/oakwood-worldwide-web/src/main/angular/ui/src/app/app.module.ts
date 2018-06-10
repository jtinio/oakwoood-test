import {environment} from '../environments/environment';
import {AppMaterialModule} from './_app-material/app-material.module';
import {AuthGuard} from './_guards/auth.guard';
import {RoleGuard} from './_guards/role.guard';
import {UserApiService} from './_services/api/user-api.service';
import {AuthenticationService} from './_services/authentication.service';
import {GlobalUtilService} from './_utils/global-util.service';
import {ResponseMessageUtilService} from './_utils/response-message-util.service';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {appRouterModule} from './app.routes';
import {LoginComponent} from './pages/login/login.component';
import {RegistrationComponent} from './pages/registration/registration.component';
import {HomeComponent} from './pages/home/home.component';
import {HttpClientModule} from '@angular/common/http';
import {FlexLayoutModule} from '@angular/flex-layout';
import {ReactiveFormsModule, FormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {Ng4LoadingSpinnerService} from 'ng4-loading-spinner';
import {NavbarComponent} from './_templates/navbar/navbar.component';
import {LayoutModule} from '@angular/cdk/layout';
import {DataTableComponent} from './_templates/data-table/data-table.component';
import {DashComponent} from './_templates/dash/dash.component';
import {MatGridListModule, MatCardModule, MatMenuModule, MatIconModule, MatButtonModule} from '@angular/material';
import {ToastrModule} from 'ngx-toastr';
import {UserFormComponent} from './forms/user-form/user-form.component';
import {JwtModule} from '@auth0/angular-jwt';
import { ToolbarMenuComponent } from './_templates/toolbar-menu/toolbar-menu.component';
import { UserDatatableComponent } from './datatables/user-datatable/user-datatable.component';
import { UserManagementComponent } from './pages/user/user-management/user-management.component';
import { UserCreationComponent } from './pages/user/user-creation/user-creation.component';
import { UserUpdateComponent } from './pages/user/user-update/user-update.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    HomeComponent,
    NavbarComponent,
    DataTableComponent,
    DashComponent,
    UserFormComponent,
    ToolbarMenuComponent,
    UserDatatableComponent,
    UserManagementComponent,
    UserCreationComponent,
    UserUpdateComponent
  ],
  imports: [
    BrowserModule,
    JwtModule.forRoot({
      config: {
        tokenGetter: () => {
          return localStorage.getItem('token');
        },
        whitelistedDomains: [environment.WHITE_LISTED_DOMAIN],
        blacklistedRoutes: [environment.BLACK_LISTED_DOMAIN]
      }
    }),
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    appRouterModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    AppMaterialModule,
    FlexLayoutModule,
    LayoutModule,
    MatGridListModule,
    MatCardModule,
    MatMenuModule,
    MatIconModule,
    MatButtonModule,
  ],
  providers: [GlobalUtilService,
    ResponseMessageUtilService,
    //    {
    //      provide: HTTP_INTERCEPTORS,
    //      useClass: JwtInterceptor,
    //      multi: true
    //    },
    AuthGuard,
    RoleGuard,
    Ng4LoadingSpinnerService,
    AuthenticationService,
    UserApiService],
  bootstrap: [AppComponent]
})
export class AppModule {}
