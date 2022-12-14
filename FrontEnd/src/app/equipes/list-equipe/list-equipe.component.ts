import { Equipes } from './../../core/model/equipes';
import { EquipesService } from './../../core/service/equipes.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-equipe',
  templateUrl: './list-equipe.component.html',
  styleUrls: ['./list-equipe.component.scss'],
})
export class ListEquipeComponent implements OnInit {
  public listEquipe: Equipes[];

  constructor(private equipesService: EquipesService) {}

  ngOnInit(): void {
    this.equipesService.getAllEquipes().subscribe((data: Equipes[]) => {
      this.listEquipe = data;
    });
  }
}