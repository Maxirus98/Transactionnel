import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Citizen } from 'src/app/model/citizen';

@Component({
  selector: 'app-permis',
  templateUrl: './permis.component.html',
  styleUrls: ['./permis.component.css'],
})
export class PermisComponent implements OnInit {
  messageValidation: string = '';

  //Sans généricité
  constructor(private httpClient: HttpClient, private router: Router) {}

  ngOnInit(): void {}
  userForm = new FormGroup({
    nassm: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
    typePermis: new FormControl('', Validators.required),
    notes: new FormControl(''),
  });

  //Gère les erreurs
  httpOptions = {
    headers: new HttpHeaders({
      //Pour recevoir les erreurs sous forme JSON
      'Content-Type': 'application/json',
    }),
  };

  public OnSubscribe() {
    if (this.userForm.valid) {
      //Pour changer les champs en string
      const ouf = JSON.stringify(this.userForm.value);
      //<> = ce que le controller retourne
      // la partie chemin de l'url doit se retrouver dans la méthode du controller
      this.httpClient
        .post<Citizen>(
          'http://localhost:9292/permisSante/request1',
          ouf,
          this.httpOptions
        )
        .subscribe((valeurDeRetourDuCall) => {
          //Publiser/subscriber:Observable Observer Design Pattern
          if (valeurDeRetourDuCall != null) {
            this.router.navigateByUrl('/home');
          }
          (err) => {
            //Au cas ou il y a une erreur
            console.log(err);
          };
        });
    } else {
      this.messageValidation = 'Please fill form correctly.';
    }
  }
}
