import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Citoyen } from 'src/app/models/citoyen';
import { Tuteur } from 'src/app/models/tuteur';
import { CitoyenService } from 'src/app/services/citoyen.service';
import { TuteurService } from 'src/app/services/tuteur.service';

@Component({
  selector: 'app-tuteur',
  templateUrl: './tuteur.component.html',
  styleUrls: ['./tuteur.component.css'],
})
export class TuteurComponent implements OnInit {
  messageValidation: string = '';
  tuteur: Tuteur;
  formTuteur = new FormGroup({
    courriel: new FormControl('', Validators.required),
  });
  constructor(private router: Router, private service: TuteurService) {}

  ngOnInit(): void {}

  private randomValidationCode(): string {
    var randomCode: string = '';
    for (var i = 0; i < 6; i++) {
      randomCode += String.fromCharCode(Math.abs(Math.random() * 25 + 65));
    }
    return randomCode;
  }

  public sendEmail() {
    if (this.formTuteur.valid) {
      this.tuteur = new Tuteur();
      var message: string = this.randomValidationCode();
      this.tuteur.courriel = this.formTuteur.value.courriel;
      this.service
        .sendEmail(this.tuteur, this.tuteur.courriel, message)
        .subscribe((reponse) => {
          if (reponse != null) {
            this.router.navigate(['/subscribe', { enfant: true }]);
            localStorage.setItem('code', message);
          }
        });
    } else {
      this.messageValidation = 'Veuillez entrer votre courriel';
    }
  }
}
