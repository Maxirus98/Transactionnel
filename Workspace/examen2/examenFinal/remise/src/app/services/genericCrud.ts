import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export class GenericCrud<T, ID> {
  constructor(protected http: HttpClient, protected url: string) {
    http = this.http;
  }
  save(t: T): Observable<T> {
    return this.http.post<T>(this.url + '/comptes', t);
  }

  findAll(): Observable<T[]> {
    return this.http.get<T[]>(this.url);
  }

  findById(id: ID): Observable<T> {
    return this.http.get<T>(this.url + '/comptes' + '?id=' + id);
  }

  deleteById(id: ID): Observable<T> {
    return this.http.delete<T>(this.url + '/comptes' + '/' + id);
  }
}
