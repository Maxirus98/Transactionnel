import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http';

export class GenericService{
    constructor(protected http: HttpClient, protected url:String) {
        
    }
    login(email: string, password: string): Observable<boolean>{
        return this.http.get<boolean>(this.url + '/' + email + '/' + password);
    }
}