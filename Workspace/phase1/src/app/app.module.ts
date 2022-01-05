import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { Error404Component } from './error404/error404.component';
import { DemandePermisComponent } from './demande-permis/demande-permis.component';
import { SubscribeComponent } from './components/subscribe/subscribe.component';
import { LoginComponent } from './components/login/login.component';
import { LogoutComponent } from './components/logout/logout.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { GenericService } from './service/generic-service.ts/generic-service.ts.component';

@NgModule({
  declarations: [
    AppComponent,
    Error404Component,
    DemandePermisComponent,
    SubscribeComponent,
    LoginComponent,
    LogoutComponent,
    DashboardComponent,
    GenericService.TsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
