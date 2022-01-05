import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
})
export class MenuComponent implements OnInit {
  // TODO: Changer le bouton se Connecter par se Déconnecter lorsque l'utilisateur est connecter.
  // Ne pas oublier : L'utilisateur est déconnecté dès qu'il atteint son dashboard, alors seulement faire une méthode qui l'envoie vers home
  constructor() {}

  ngOnInit(): void {}
}
