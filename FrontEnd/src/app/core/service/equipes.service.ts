import { environment } from './../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Equipes } from './../model/equipes';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class EquipesService {
  public uri = environment.uri + 'Equipe/';

  constructor(private http: HttpClient) {}

  getAllEquipes() {
    return this.http.get<Equipes[]>(this.uri + 'getAll');
  }
  addEquipe(e: Equipes) {
    return this.http.post(this.uri + 'add', e);
  }
  deleteEquipe(id: number) {
    return this.http.delete(this.uri + 'delete/' + id);
  }
  updateEquipe(e: Equipes) {
    return this.http.put(this.uri + 'update/', e);
  }
  getEquipeById(id: number) {
    return this.http.get<Equipes>(this.uri + 'getById/' + id);
  }
}
