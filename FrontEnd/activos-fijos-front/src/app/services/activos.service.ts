import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class ActivosService {

  url = 'http://localhost:8080/asd/obtenerActivos'
  urlCiud = 'http://localhost:8080/asd/obtenerCiudades'

  constructor(private http: HttpClient) {
    console.log('Servicio de activos');
   }

   getActivos(){
      let header = new HttpHeaders().set('Type-content', 'aplication/json')
      return this.http.get(this.url, {
        headers: header
      });      
   }

   getCiudades(idactivos:any){
    let header = new HttpHeaders().set('Type-content', 'aplication/json')
    console.log('id activo in call'+ idactivos);
    return this.http.get(this.urlCiud, {
      headers: header, params: {idActivo: idactivos}
    });
   }
}
