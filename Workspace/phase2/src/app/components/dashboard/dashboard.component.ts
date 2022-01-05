import { Component, OnInit } from '@angular/core';
import { Citizen } from 'src/app/models/citizen';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  //Récupérer le subscribe
  citizen: Citizen;
  
  constructor() { }

  ngOnInit(): void {
    //Pour trouver le state en mémoire
    this.citizen = history.state;
  }

}
