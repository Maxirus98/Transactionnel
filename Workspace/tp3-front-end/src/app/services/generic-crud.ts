import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

export class GenericCrud<T, ID>{
    constructor(private http: HttpClient, private url: string) {
        
    }
    save(t: T): Observable<T> {
        return this.http.post<T>(this.url, t);
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
      login(email: string, password: string): Observable<T>{
        return this.http.get<T>(this.url + '?courriel=' + email + '&pwd=' + password);
      }
    
      update(id: ID, t: T): Observable<T> {
        return this.http.put<T>(this.url + '/' + id, t, {});
      }
    
      deleteById(id: ID): Observable<T> {
        return this.http.delete<T>(this.url + '/' + id);
      }
}
