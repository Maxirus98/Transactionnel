import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnChanges, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {
  ActivatedRoute,
  Router,
  RouterState,
  RouterStateSnapshot,
} from '@angular/router';
import { Permis } from 'src/app/models/permis';
import { CitoyenService } from 'src/app/services/citoyen.service';
import { PermisService } from 'src/app/services/permis.service';

@Component({
  selector: 'app-subscribe',
  templateUrl: './subscribe.component.html',
  styleUrls: ['./subscribe.component.css'],
})

//TODO : State doesn't work
export class SubscribeComponent implements OnInit {
  messageValidation: string = '';
  isEnfant;
  permis: Permis;
  verificationTuteur: string;
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
    enfant: new FormControl(''),
  });
  constructor(
    private router: Router,
    private service: PermisService,
    private serviceCitoyen: CitoyenService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.isEnfant = this.route.snapshot.paramMap.get('enfant');
    console.log(this.isEnfant);
  }

  public onSubscribe() {
    console.log(this.formSubscribe.value);
    if (
      this.formSubscribe.valid &&
      (this.verifyValidationCode() || this.isEnfant === null)
    ) {
      this.serviceCitoyen
        .save(
          this.formSubscribe.value,
          this.formSubscribe.value.courriel,
          this.formSubscribe.value.password
        )
        .subscribe((data) => {
          if (data != null) {
            this.permis = new Permis(data);
            this.permis.typePermis = this.formSubscribe.value.choixPermisRadio;
            if (this.formSubscribe.value.choixPermisRadio == 'test') {
              this.service
                .saveTest(
                  this.permis,
                  this.permis.citoyen.courriel,
                  this.permis.citoyen.password
                )
                .subscribe((permis) => {
                  if (permis != null) {
                    this.formSubscribe.reset();
                    this.router.navigateByUrl('/login', { state: data });
                  }
                });
            } else {
              this.service
                .save(
                  this.permis,
                  this.permis.citoyen.courriel,
                  this.permis.citoyen.password
                )
                .subscribe((permis) => {
                  if (permis != null) {
                    this.formSubscribe.reset();
                    this.router.navigateByUrl('/login', { state: data });
                  }
                });
            }
          } else {
            this.messageValidation = 'Les informations entrés existent déjà';
          }
        });
    } else {
      this.messageValidation = 'Entrer correctement les informations';
    }
  }

  private verifyValidationCode(): boolean {
    var input: string = this.formSubscribe.value.enfant;
    if (input.toUpperCase() == localStorage.getItem('code')) {
      return true;
    }
    return false;
  }
}
