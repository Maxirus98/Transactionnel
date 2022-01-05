import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router, CanDeactivate } from '@angular/router';
import { Observable } from 'rxjs';
import { PermisService } from './permis.service';
;


@Injectable({
  providedIn: 'root'
})
  //Activer la route ou desactiver la route, dépend de l'interface implementé
export class AuthGuard implements CanActivate{

  constructor(private router: Router, private citoyenService: PermisService) {
    
  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (this.citoyenService.userSignedIn()) 
      return true;
    this.router.navigateByUrl('/home');
    return false;
  }
  
}
