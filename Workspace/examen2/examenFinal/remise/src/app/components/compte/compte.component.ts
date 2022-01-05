import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Compte } from 'src/app/models/compte';
import { CompteService } from 'src/app/services/compte.service';

@Component({
  selector: 'app-compte',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.css'],
})
export class CompteComponent implements OnInit {
  messageValidation: string = '';
  compte: Compte;
  formCheque = new FormGroup({
    nom: new FormControl('', Validators.required),
    prenom: new FormControl('', Validators.required),
    ouverture: new FormControl('', Validators.required),
  });
  constructor(private router: Router, private service: CompteService) {}

  ngOnInit(): void {}
  creerCompteCheque() {
    //post
    if (this.formCheque.valid && this.formCheque.value.ouverture >= 20) {
      this.compte = new Compte();
      this.compte.nom = this.formCheque.value.nom;
      this.compte.prenom = this.formCheque.value.prenom;
      this.compte.ouverture = this.formCheque.value.ouverture;
      this.service.save(this.compte).subscribe((compte) => {
        if (compte != null) {
          this.router.navigateByUrl('/liste');
        } else {
          this.messageValidation = 'Les informations entrées existent déjà.';
        }
      });
    } else {
      this.messageValidation = 'Veuillez remplir correctement le formulaire.';
    }
  }
}
