import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Citoyen } from 'src/app/models/citoyen';
import { Permis } from 'src/app/models/permis';
import { PermisService } from 'src/app/services/permis.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  citoyen: Citoyen;
  email: string;
  password: string;
  messageValidation: string = '';
  formLogin = new FormGroup({
    courriel: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  })

  constructor(private router:Router, private service:PermisService) { }

  ngOnInit(): void {
  }

  //TODO: REFACTOR
  login() {
    //this.service.login(this.email, this.password);
    if (this.formLogin.valid) {
      this.email = this.formLogin.get('courriel').value;
      this.password = this.formLogin.get('password').value;
      this.service.login(this.email, this.password).subscribe(
        (data) => {
          this.citoyen = data;
          if (this.citoyen != null) {
            sessionStorage.setItem('courriel', this.email);
            this.formLogin.reset()
            this.router.navigateByUrl('/dashboard', { state: this.citoyen });
          }
          else {
            this.messageValidation = 'Aucun compte avec ces informations'
          }
        }
      );
    }else {
      this.messageValidation = 'Entrez des informations existant';
    }
  }

  creerUnCompte(typePermis) {
    this.router.navigateByUrl('/subscribe', { state: typePermis });
  }

}
