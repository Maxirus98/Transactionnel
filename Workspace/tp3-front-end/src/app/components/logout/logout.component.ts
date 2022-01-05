import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PermisService } from 'src/app/services/permis.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private route: Router, private citoyenService:PermisService) {
    //Délog
    this.route.navigate(['home']); // ou this.route.navigateByUrl('/home');
  }

  ngOnInit(): void {
  }

}
