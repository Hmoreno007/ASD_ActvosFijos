package com.asd.activosfijos.models;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "activosfijos")
public class ActivosFijosModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;  
    
    @Column(name = "activo_nombre")
    private String activoNombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "activo_serial")
    private String activoSerial;

    @Column(name = "num_int_inventario")
    private String numIntInventario;

    @Column(name = "peso")
    private double peso;

    @Column(name = "alto")
    private double alto;

    @Column(name = "ancho")
    private double ancho;

    @Column(name = "largo")
    private double largo;

    @Column(name = "valor_compra")
    private int valorCompra;
    
    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_hora_compra")
    private Timestamp fechaHoraCompra;

    @Column(name = "fecha_hora_crea")
    private Timestamp fechaHoraCrea; 

    @Column(name = "fecha_hora_modifica")
    private Timestamp fechaHoraModifica;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getActivoNombre() {
        return activoNombre;
    }
    public void setActivoNombre(String activoNombre) {
        this.activoNombre = activoNombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getActivoSerial() {
        return activoSerial;
    }
    public void setActivoSerial(String activoSerial) {
        this.activoSerial = activoSerial;
    }
    public String getNumIntInventario() {
        return numIntInventario;
    }
    public void setNumIntInventario(String numIntInventario) {
        this.numIntInventario = numIntInventario;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public double getAlto() {
        return alto;
    }
    public void setAlto(double alto) {
        this.alto = alto;
    }
    public double getAncho() {
        return ancho;
    }
    public void setAncho(double ancho) {
        this.ancho = ancho;
    }
    public double getLargo() {
        return largo;
    }
    public void setLargo(double largo) {
        this.largo = largo;
    }
    public int getValorCompra() {
        return valorCompra;
    }
    public void setValorCompra(int valorCompra) {
        this.valorCompra = valorCompra;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Timestamp getFechaHoraCompra() {
        return fechaHoraCompra;
    }
    public void setFechaHoraCompra(Timestamp fechaHoraCompra) {
        this.fechaHoraCompra = fechaHoraCompra;
    }
    public Timestamp getFechaHoraCrea() {
        return fechaHoraCrea;
    }
    public void setFechaHoraCrea(Timestamp fechaHoraCrea) {
        this.fechaHoraCrea = fechaHoraCrea;
    }
    public Timestamp getFechaHoraModifica() {
        return fechaHoraModifica;
    }
    public void setFechaHoraModifica(Timestamp fechaHoraModifica) {
        this.fechaHoraModifica = fechaHoraModifica;
    }

    
}
