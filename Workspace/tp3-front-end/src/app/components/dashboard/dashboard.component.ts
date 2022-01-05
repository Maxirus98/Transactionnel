import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Citoyen } from 'src/app/models/citoyen';
import { PermisService } from 'src/app/services/permis.service';
import { LogoutComponent } from '../logout/logout.component';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  citoyen: Citoyen;
  constructor(private router:Router, private service:PermisService) { }

  ngOnInit(): void {
    this.citoyen = history.state;
  }
}
