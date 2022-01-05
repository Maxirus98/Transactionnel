import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export class GenericCrud<T, ID> {
  constructor(protected http: HttpClient, protected url: string) {
    http = this.http;
  }
  save(t: T, courriel: string, password: string): Observable<T> {
    return this.http.post<T>(
      this.url + '?courriel=' + courriel + '&pwd=' + password,
      t
    );
  }
  saveTest(t: T, courriel: string, password: string): Observable<T> {
    return this.http.post<T>(
      this.url + '/test' + '?courriel=' + courriel + '&pwd=' + password,
      t
    );
  }

  update(nassm: string): Observable<T> {
    return this.http.put<T>(this.url + '?nassm=' + nassm, {});
  }

  isValidCitoyen(nassm: string): Observable<boolean> {
    return this.http.get<boolean>(this.url + '/' + nassm);
  }

  //Pour le dashboard de l'admin, il pourra voir tous les citoyens inscrits
  findAll(): Observable<T[]> {
    return this.http.get<T[]>(this.url);
  }

  findById(id: ID): Observable<T> {
    return this.http.get<T>(this.url + '/' + id);
  }

  login(email: string, password: string): Observable<T> {
    return this.http.get<T>(
      this.url + '?courriel=' + email + '&pwd=' + password
    );
  }

  deleteById(id: ID): Observable<T> {
    return this.http.delete<T>(this.url + '/' + id);
  }
}
