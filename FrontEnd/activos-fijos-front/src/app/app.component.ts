import { Component } from '@angular/core';
import { ActivosService } from './services/activos.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'activos-fijos-front';
  public activos: Array<any> = []
  public ciudades: Array<any> = []
  public latitud: any
  public longitud: any
  public center: any  

  constructor(private activosService:ActivosService){
    this.activosService.getActivos().subscribe((resp: any) =>{
      console.log(resp.result);
      this.activos = resp.result
    })
  }  

  restCiudades(activo:any){    
    this.activosService.getCiudades(activo.id).subscribe((ciu: any) =>{      
      console.log("ciudad rest" + ciu.result);
      if (ciu.result.length != 0) {        
        this.ciudades = ciu.result
        this.latitud = this.ciudades[0].latitud
        this.longitud = this.ciudades[0].longitud 
        this.center = {
          lat: parseFloat(this.latitud),
          lng: parseFloat(this.longitud)
        };   
        console.log("Latitud: "+this.latitud +" Longitud: "+this.longitud);
      }      
    })
  }

  titleMaps = 'Geolocalizacion del Activo';  

  label = {
    color: 'red',
    text: 'Marcador'
  };

}
