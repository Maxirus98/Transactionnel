import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Compte } from '../models/compte';
import { Epargne } from '../models/epargne';
import { GenericCrud } from './genericCrud';

@Injectable({
  providedIn: 'root',
})
export class CompteService extends GenericCrud<Compte, Number> {
  constructor(http: HttpClient) {
    super(http, 'http://localhost:8080/all');
  }

  saveEpargne(epargne: Epargne): Observable<Epargne> {
    return this.http.post<Epargne>(this.url + '/comptes/epargne', epargne);
  }
}
