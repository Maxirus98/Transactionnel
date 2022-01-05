import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PermisService } from 'src/app/services/permis.service';

@Component({
  selector: 'app-subscribe',
  templateUrl: './subscribe.component.html',
  styleUrls: ['./subscribe.component.css']
})
export class SubscribeComponent implements OnInit {
  validMessage: string = '';
  subscribeFrom = new FormGroup({ // [formGroup]="subscribeFrom" in Angular
    firstName: new FormControl('', Validators.required),//FormControlName in angular
    lastName: new FormControl('', Validators.required),
    email: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
    nassm: new FormControl('', Validators.required)
  });
  url:string = "http://localhost:9292/permisSante"
  constructor(private service:PermisService, private router:Router) { }

  ngOnInit(): void {
    
  }

  public onSubscribe() {
    if (this.subscribeFrom.valid) {
      // Il FAUT SUBSCRIBE POUR METHODES OBSERVABLE
      this.service.save(this.subscribeFrom.value).subscribe(
        //résultat de l'appelle au WS, data ne sera pas null si ca se passe bien
        (data) => {
          if (data != null) {
            this.subscribeFrom.reset();
            //Passer la paramètre state en mémoire
            this.router.navigateByUrl('/dashboard', {state: data})
          }
          else {
            this.validMessage = "Impossible de s'inscrire";
          }
        }
      )
    }
    else {
      this.validMessage = "Please fill form correctly";
    }
  }

}
