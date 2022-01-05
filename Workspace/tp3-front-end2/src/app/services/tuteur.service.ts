import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TuteurComponent } from '../components/tuteur/tuteur.component';
import { Tuteur } from '../models/tuteur';
import { GenericCrud } from './generic-crud';

@Injectable({
  providedIn: 'root',
})
export class TuteurService extends GenericCrud<TuteurComponent, Number> {
  constructor(http: HttpClient) {
    super(http, 'http://localhost:8484/permisSante/tuteurValid');
  }

  public sendEmail(
    citoyen: Tuteur,
    courriel: string,
    codeValidation: string
  ): Observable<Tuteur> {
    return this.http.post<Tuteur>(this.url + '?courriel=' + courriel, citoyen);
  }
}
