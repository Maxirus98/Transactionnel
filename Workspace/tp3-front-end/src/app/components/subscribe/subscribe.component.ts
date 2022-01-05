import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router, RouterState, RouterStateSnapshot } from '@angular/router';
import { PermisService } from 'src/app/services/permis.service';

@Component({
  selector: 'app-subscribe',
  templateUrl: './subscribe.component.html',
  styleUrls: ['./subscribe.component.css']
})
  
  //TODO : State doesn't work  
export class SubscribeComponent implements OnInit {
  messageValidation: string = '';
  typePermis: string;
  formSubscribe = new FormGroup({
    nom: new FormControl('', Validators.required),
    prenom: new FormControl('', Validators.required),
    sexe: new FormControl('', Validators.required),
    nassm: new FormControl('', Validators.required),
    telephone: new FormControl('', Validators.required),
    age: new FormControl('', Validators.required),
    courriel: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
    choixPermisRadio: new FormControl('', Validators.required),
  })
  constructor(private router:Router, private service:PermisService) { }

  ngOnInit(): void {
    console.log(history.state);
  }

  //TODO: REFACTOR
  public onSubscribe() {
    console.log(this.formSubscribe.value);
    if (this.formSubscribe.valid) {
      // Il FAUT SUBSCRIBE POUR METHODES OBSERVABLE
      this.service.save(this.formSubscribe.value).subscribe(
        //résultat de l'appelle au WS, data ne sera pas null si ca se passe bien
        (data) => {
          if (data != null) {
            this.formSubscribe.reset();
            //Passer la paramètre state en mémoire
            this.router.navigateByUrl('/login', {state: data})
          }
          else {
            this.messageValidation = "Impossible de s'inscrire";
          }
        }
      )
    }
    else {
      this.messageValidation = "Entrer correctement les informations";
    }
  }

}
