package com.asd.activosfijos.repositories;

import java.sql.Timestamp;
import java.util.List;

import com.asd.activosfijos.models.ActivosFijosModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivosFijosRepository extends CrudRepository<ActivosFijosModel, Long>{
    
    @Query(value = "SELECT activosfijos.* FROM activosfijos WHERE activosfijos.tipo = ?1", nativeQuery = true)
    public List<ActivosFijosModel> findActivosFijosByTipo(String tipo);

    @Query(value = "SELECT activosfijos.* FROM activosfijos WHERE activosfijos.tipo = ?1 AND activosfijos.activo_serial = ?2 AND activosfijos.fecha_hora_compra = ?3", nativeQuery = true)
    public List<ActivosFijosModel> findActivosFijosFiltros(String tipo, String serial, Timestamp fechaCompra);

    @Query(value = "SELECT activosfijos.* FROM activosfijos WHERE activosfijos.tipo = ?1 AND activosfijos.fecha_hora_compra = ?2", nativeQuery = true)
    public List<ActivosFijosModel> findActivosFijosByTipoFecha(String tipo, Timestamp fechaCompra);

    @Query(value = "SELECT activosfijos.* FROM activosfijos WHERE activosfijos.tipo = ?1 AND activosfijos.serial = ?2", nativeQuery = true)
    public List<ActivosFijosModel> findActivosFijosByTipoSerial(String tipo, String serial);

    @Query(value = "SELECT activosfijos.* FROM activosfijos WHERE activosfijos.serial = ?1 AND activosfijos.fecha_hora_compra = ?2", nativeQuery = true)
    public List<ActivosFijosModel> findActivosFijosByFechaSerial(String serial, Timestamp fechaCompra);

    @Query(value = "SELECT activosfijos.* FROM activosfijos WHERE activosfijos.serial = ?1", nativeQuery = true)
    public List<ActivosFijosModel> findActivosFijosBySerial(String serial);

    @Query(value = "SELECT activosfijos.* FROM activosfijos WHERE activosfijos.fecha_hora_compra = ?1", nativeQuery = true)
    public List<ActivosFijosModel> findActivosFijosByFecha(Timestamp fechaCompra);
}
