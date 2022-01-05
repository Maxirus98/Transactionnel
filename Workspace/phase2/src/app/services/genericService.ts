import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export class GenericService<T, ID> {
  constructor(protected http: HttpClient, protected url: string) {}

  save(t: T): Observable<T> {
    return this.http.post<T>(this.url, t);
  }

  findAll(): Observable<T[]> {
    return this.http.get<T[]>(this.url);
  }

  findById(id: ID): Observable<T> {
    return this.http.get<T>(this.url + '/' + id);
  }

  checkCitizenValidity(nassm: string): Observable<boolean> {
    return this.http.get<boolean>(this.url + '/' + nassm);
  }

  /**
  checkCitizenValidity2(nassm: string, email: string): Observable<boolean> {
    return this.http.get<boolean>(this.url + '/' + nassm + '&' + email);
  }
  */

  upadate(id: ID, t: T): Observable<T> {
    return this.http.put<T>(this.url + '/' + id, t, {});
  }

  deleteById(id: ID): Observable<T> {
    return this.http.delete<T>(this.url + '/' + id);
  }
}
