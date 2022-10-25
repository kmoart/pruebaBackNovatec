import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { usuarioModel } from '../models/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  private url = 'http://localhost:8080/usuario';

  constructor(private http: HttpClient) {  }

  getUsuarios(){
    return this.http.get( `${ this.url }`);
  }

  crearUsuario( usuario: usuarioModel){
    return this.http.post(`${ this.url }`, usuario);
  }
}
