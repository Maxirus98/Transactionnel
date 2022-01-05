import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-demande-permis',
  templateUrl: './demande-permis.component.html',
  styleUrls: ['./demande-permis.component.css']
})
export class DemandePermisComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  demandePermisForm = new FormGroup({
    email: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  })

}
