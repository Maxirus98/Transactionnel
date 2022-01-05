import { NgModule, LOCALE_ID } from '@angular/core'; // LOCALE ID = VARIABLE
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PermisComponent } from './components/permis/permis.component';
import { registerLocaleData } from '@angular/common';

//Afficher les dates en francais
registerLocaleData(localeFr);

@NgModule({
  declarations: [AppComponent, PermisComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [{ provide: LOCALE_ID, useValue: 'fr-FR' }],
  bootstrap: [AppComponent],
})
export class AppModule {}
function localeFr(localeFr: any) {
  throw new Error('Function not implemented.');
}
