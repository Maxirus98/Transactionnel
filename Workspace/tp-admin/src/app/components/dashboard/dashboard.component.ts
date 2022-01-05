import { Component, OnInit } from '@angular/core';
import { Permis } from 'src/app/models/permis';
import { PermisService } from 'src/app/services/permis.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit {
  opermis: Permis;
  permis: Permis[];
  isPermisTest: boolean;
  constructor(
    private service: PermisService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.remplirDashboard();
  }

  public remplirDashboard() {
    this.service.findAll().subscribe((permis) => {
      this.permis = permis;
      console.log(this.permis);
    });
  }

  public renouvellerPermis(id: number) {
    this.service.findTestById(id).subscribe((unPermis) => {
      this.service.renouvellerPermisTest(unPermis, id).subscribe(() => {
        alert(
          'Le permis de ' +
            unPermis.citoyen.prenom +
            ', ' +
            unPermis.citoyen.nom +
            ' a été renouvellé'
        );
      });
    });
  }

  public deletePermis(id: number) {
    this.service.findById(id).subscribe((unPermis) => {
      this.service.deleteById(id).subscribe(() => {
        //Note : J'appelle le HttpClient directement au lieu d'une méthode du service
        this.service.http
          .delete('http://localhost:8585/permisSante?ID=' + unPermis.citoyen.id)
          .subscribe();
        alert(
          'Le permis de ' +
            unPermis.citoyen.nom +
            ', ' +
            unPermis.citoyen.prenom +
            ' a été supprimé.'
        );
        this.ngOnInit();
      });
    });
  }
}
