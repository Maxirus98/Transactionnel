import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GenericService } from './genericService';

@Injectable({
  providedIn: 'root'
})
export class MinistereService extends GenericService{

  constructor(http:HttpClient) {
    super(http, 'http://localhost:8282');
  }
}
