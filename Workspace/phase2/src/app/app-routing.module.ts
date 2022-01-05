import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { Error404Component } from './components/error404/error404.component';
import { LoginComponent } from './components/login/login.component';
import { LogoutComponent } from './components/logout/logout.component';
import { PermisRequestComponent } from './components/permis-request/permis-request.component';
import { SubscribeComponent } from './components/subscribe/subscribe.component';

const routes: Routes = [
  {path:'dashboard', component:DashboardComponent}, //condition sur les pages 
  {path:'subscribe', component:SubscribeComponent},
  {path:'logout', component:LogoutComponent}, //condition sur les pages 
  {path:'login', component:LoginComponent},
  { path: 'home', component: PermisRequestComponent },
  { path:'', redirectTo:'/home', pathMatch:'full'},
  { path: '**', component: Error404Component },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
