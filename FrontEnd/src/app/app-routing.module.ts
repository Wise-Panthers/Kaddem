import { NgModule } from '@angular/core';
import { RouterModule, Routes, PreloadAllModules } from '@angular/router';

import { FullLayoutComponent } from './layouts/full/full-layout.component';
import { ContentLayoutComponent } from './layouts/content/content-layout.component';

import { Full_ROUTES } from './shared/routes/full-layout.routes';
import { CONTENT_ROUTES } from './shared/routes/content-layout.routes';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'dashboard/default',
    pathMatch: 'full',
  },
  { path: '', component: FullLayoutComponent, data: { title: 'full Views' }, children: Full_ROUTES },
  { path: '', component: ContentLayoutComponent, data: { title: 'content Views' }, children: CONTENT_ROUTES },
  { path: 'etudiants', loadChildren: () => import('./etudiants/etudiants.module').then(m => m.EtudiantsModule) },
  { path: 'univDepart', loadChildren: () => import('./univ-depart/univ-depart.module').then(m => m.UnivDepartModule) },
  { path: 'equipes', loadChildren: () => import('./equipes/equipes.module').then(m => m.EquipesModule) },
  { path: 'Entreprise', loadChildren: () => import('./entreprise/entreprise.module').then(m => m.EntrepriseModule) },
  { path: 'Projet', loadChildren: () => import('./projet/projet.module').then(m => m.ProjetModule) },
  { path: 'encadrant', loadChildren: () => import('./encadrant/encadrant.module').then(m => m.EncadrantModule) },
  { path: 'contract', loadChildren: () => import('./contract/contract.module').then((m) => m.ContractModule) },
  { path: '**', redirectTo: 'dashboard/default' },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules }),
  ],
  exports: [RouterModule],
})
export class AppRoutingModule {}
