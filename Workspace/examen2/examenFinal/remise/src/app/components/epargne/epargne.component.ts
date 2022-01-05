import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Compte } from 'src/app/models/compte';
import { CompteService } from 'src/app/services/compte.service';

@Component({
  selector: 'app-epargne',
  templateUrl: './epargne.component.html',
  styleUrls: ['./epargne.component.css'],
})
export class EpargneComponent implements OnInit {
  constructor(private router: Router, private service: CompteService) {}
  formEpargne = new FormGroup({
    visee: new FormControl('', Validators.required),
    taux: new FormControl('', Validators.required),
    id: new FormControl(0, Validators.required),
  });
  ngOnInit(): void {}

  creerCompteEpargne() {
    //verifier valid
    if (this.formEpargne.valid) {
      this.service.findById(this.formEpargne.value.id).subscribe((compte) => {
        if (compte != null) {
          compte.sommeVisee = this.formEpargne.value.visee;
          compte.taux = this.formEpargne.value.taux;
          this.service.saveEpargne(compte).subscribe(() => {
            this.router.navigateByUrl('/liste');
          });
        }
      });
    }
    //verifier compte cheque existe par son id
  }
}
