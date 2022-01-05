import { HttpClient } from '@angular/common/http';
import { EventEmitter, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Citoyen } from '../models/citoyen';
import { GenericCrud } from './generic-crud';

@Injectable({
  providedIn: 'root',
})
export class CitoyenService extends GenericCrud<Citoyen, Number> {
  constructor(http: HttpClient) {
    super(http, 'http://localhost:8484/permisSante');
  }

  public userSignedIn(): boolean {
    let courriel = sessionStorage.getItem('courriel');
    return courriel != null;
  }

  public findByNassm(nassm: string): Observable<Citoyen> {
    return this.http.get<Citoyen>(this.url + '?=' + nassm);
  }

  public findByCourriel(courriel: string): Observable<Citoyen> {
    return this.http.get<Citoyen>(this.url + '?=' + courriel);
  }

  public updatePassword(nassm: string, citoyen: Citoyen): Observable<Citoyen> {
    return this.http.put<Citoyen>(this.url + '?nassm=' + nassm, citoyen, {});
  }

  public logout() {
    sessionStorage.clear();
  }
}
