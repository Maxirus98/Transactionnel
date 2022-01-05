import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CompteComponent } from './components/compte/compte.component';
import { EpargneComponent } from './components/epargne/epargne.component';
import { ListeComponent } from './components/liste/liste.component';

const routes: Routes = [
  { path: '', component: CompteComponent },
  { path: 'compte', component: CompteComponent },
  { path: 'epargne', component: EpargneComponent },
  { path: 'liste', component: ListeComponent },
  { path: '**', component: CompteComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
