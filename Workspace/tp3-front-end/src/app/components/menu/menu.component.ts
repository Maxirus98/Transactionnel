import { Component, OnInit } from '@angular/core';
import { PermisService } from 'src/app/services/permis.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(public service: PermisService) {
  }

  ngOnInit(): void {
  }

}
