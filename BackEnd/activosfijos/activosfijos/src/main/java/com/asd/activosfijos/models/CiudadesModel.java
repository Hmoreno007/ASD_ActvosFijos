package com.asd.activosfijos.models;

import javax.persistence.*;

@Entity
@Table(name = "ciudades")
public class CiudadesModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;  

    @Column(name = "ciudad_codigo")
    private String ciudadCodigo;

    @Column(name = "ciudad_nombre")
    private String ciudadNombre;

    @Column(name = "latitud")
    private String latitud;

    @Column(name = "longitud")
    private String longitud;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_hora_crea")
    private String fechaHoraCrea;

    @Column(name = "fecha_hora_modifica")
    private String fechaHoraModifica;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCiudadCodigo() {
        return ciudadCodigo;
    }

    public void setCiudadCodigo(String ciudadCodigo) {
        this.ciudadCodigo = ciudadCodigo;
    }

    public String getCiudadNombre() {
        return ciudadNombre;
    }

    public void setCiudadNombre(String ciudadNombre) {
        this.ciudadNombre = ciudadNombre;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaHoraCrea() {
        return fechaHoraCrea;
    }

    public void setFechaHoraCrea(String fechaHoraCrea) {
        this.fechaHoraCrea = fechaHoraCrea;
    }

    public String getFechaHoraModifica() {
        return fechaHoraModifica;
    }

    public void setFechaHoraModifica(String fechaHoraModifica) {
        this.fechaHoraModifica = fechaHoraModifica;
    }

        
}
