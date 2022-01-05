import { serializeNodes } from '@angular/compiler/src/i18n/digest';
import { stringify } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Compte } from 'src/app/models/compte';
import { Epargne } from 'src/app/models/epargne';
import { CompteService } from 'src/app/services/compte.service';

@Component({
  selector: 'app-liste',
  templateUrl: './liste.component.html',
  styleUrls: ['./liste.component.css'],
})
export class ListeComponent implements OnInit {
  comptes: Compte[];
  constructor(private service: CompteService) {}

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.service.findAll().subscribe((comptes) => {
      this.comptes = comptes;
    });
  }

  delete(id: number) {
    this.service.deleteById(id).subscribe((compte) => {
      alert(compte + ' supprimé');
    });
  }
}
