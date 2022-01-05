import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Citoyen } from 'src/app/models/citoyen';
import { Permis } from 'src/app/models/permis';

import { CitoyenService } from 'src/app/services/citoyen.service';
import { PermisService } from 'src/app/services/permis.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit, OnDestroy {
  permis: Permis;
  constructor(
    private citoyenService: CitoyenService,
    private service: PermisService
  ) {}

  ngOnInit(): void {
    this.permis = history.state;
  }

  ngOnDestroy(): void {
    //this.citoyenService.logout();
  }
  public renouvellerPermis() {
    if (
      this.service.findPermisByCourrielAndPwd(
        this.permis.citoyen.courriel,
        this.permis.citoyen.password
      )
    ) {
      console.log(this.permis.idPermis);
      this.service
        .renouvellerPermisTest(this.permis, this.permis.idPermis)
        .subscribe(() => {
          this.ngOnInit();
        });
    }
  }
}
