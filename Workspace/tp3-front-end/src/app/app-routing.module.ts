import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { Error404Component } from './components/error404/error404.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { LogoutComponent } from './components/logout/logout.component';
import { MenuComponent } from './components/menu/menu.component';
import { SubscribeComponent } from './components/subscribe/subscribe.component';
import { AuthGuard } from './services/auth.guard';

const routes: Routes = [
  {path: 'home', component: HomeComponent },
  {path: 'menu', component: MenuComponent },
  {path: 'login', component: LoginComponent },
  {path: 'logout', component: LogoutComponent,canActivate:[AuthGuard]},
  {path: 'subscribe', component: SubscribeComponent },
  {path: 'dashboard', component:DashboardComponent, /*canActivate:[AuthGuard]*/},
  {path: '', redirectTo:'/home', pathMatch:'full'},
  {path: '**', component:Error404Component}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
