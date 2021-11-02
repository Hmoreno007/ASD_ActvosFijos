package com.asd.activosfijos.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

import com.asd.activosfijos.models.CiudadesModel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface CiudadesRepository extends CrudRepository<CiudadesModel, Long>{
    
    @Query(value = "SELECT * FROM ciudades WHERE id = (SELECT ciudad_id FROM areas WHERE id = (SELECT area_id FROM activoarea WHERE activo_id = ?1))", nativeQuery = true)
    public List<CiudadesModel> findCiudadesByActivo(Long activo);
}
