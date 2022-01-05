import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Citoyen } from '../models/citoyen';

export class GenericCrud<T, ID> {
  constructor(public http: HttpClient, protected url: string) {
    http = this.http;
  }

  findAll(): Observable<T[]> {
    return this.http.get<T[]>(this.url);
  }

  findById(id: ID): Observable<T> {
    return this.http.get<T>(this.url + '/' + id);
  }

  findTestById(id: ID): Observable<T> {
    return this.http.get<T>(this.url + '/test?ID_PERMIS=' + id);
  }

  deleteById(id: ID): Observable<T> {
    return this.http.delete<T>(this.url + '?ID_PERMIS=' + id);
  }
}
