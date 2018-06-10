import {AuthGuard} from './_guards/auth.guard';
import { RoleGuard } from './_guards/role.guard';
import {HomeComponent} from './pages/home/home.component';
import {LoginComponent} from './pages/login/login.component';
import {UserManagementComponent} from './pages/user/user-management/user-management.component';
import { UserUpdateComponent } from './pages/user/user-update/user-update.component';
import {RegistrationComponent} from './pages/registration/registration.component';
import { UserCreationComponent } from './pages/user/user-creation/user-creation.component';
import {Routes, RouterModule, PreloadAllModules} from '@angular/router';

const ROUTES: Routes = [
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'userManagement',
    component: UserManagementComponent,
    canActivate: [RoleGuard],
    data: {
      expectedRoles: ['WRITE_PERMISSION']
    }
  },
   {
    path: 'userCreation',
    component: UserCreationComponent,
    canActivate: [RoleGuard],
    data: {
      expectedRoles: ['WRITE_PERMISSION']
    }
  },
  {
    path: 'users/details/:id',
    component: UserUpdateComponent,
    canActivate: [RoleGuard],
    data: {
      expectedRoles: ['WRITE_PERMISSION']
    }
  },
  {
    path: 'registration',
    component: RegistrationComponent,
  },
  {
    path: 'home',
    component: HomeComponent,
    canActivate: [AuthGuard]
  },
  {path: '**', redirectTo: '/login'}
];

export const appRouterModule = RouterModule.forRoot(ROUTES, {preloadingStrategy: PreloadAllModules});
