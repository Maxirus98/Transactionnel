import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Citoyen } from '../models/citoyen';
import { Permis } from '../models/permis';
import { GenericCrud } from './generic-crud';

@Injectable({
  providedIn: 'root'
})
  
export class PermisService extends GenericCrud<Citoyen, Number>{

  constructor(http: HttpClient) {
    super(http, 'http://localhost:8484/permisSante');
    
  }

  public userSignedIn():boolean {
    let courriel = sessionStorage.getItem('courriel');
    return courriel != null;
  }

  public logout() {
    sessionStorage.clear();
  }
}
