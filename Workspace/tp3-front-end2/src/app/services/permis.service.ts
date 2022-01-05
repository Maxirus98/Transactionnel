import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Citoyen } from '../models/citoyen';
import { Permis } from '../models/permis';
import { GenericCrud } from './generic-crud';

@Injectable({
  providedIn: 'root',
})
export class PermisService extends GenericCrud<Permis, Number> {
  constructor(http: HttpClient) {
    super(http, 'http://localhost:8484/permisSantePermis');
  }

  findPermisByCourrielAndPwd(
    courriel: string,
    pwd: string
  ): Observable<Permis> {
    return this.http.get<Permis>(
      this.url + '?courriel=' + courriel + '&pwd=' + pwd
    );
  }

  renouvellerPermisTest(permis: Permis, id: number): Observable<Permis> {
    return this.http.put<Permis>(this.url + '/test?ID_PERMIS=' + id, permis);
  }

  findPermisTestByCourrielAndPwd(
    courriel: string,
    pwd: string
  ): Observable<Permis> {
    return this.http.get<Permis>(
      this.url + '/test' + '?courriel=' + courriel + '&pwd=' + pwd
    );
  }
}
