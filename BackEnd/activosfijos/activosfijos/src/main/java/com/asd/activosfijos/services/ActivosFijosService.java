package com.asd.activosfijos.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.asd.activosfijos.dto.ResponseDTO;
import com.asd.activosfijos.models.ActivosFijosModel;
import com.asd.activosfijos.models.CiudadesModel;
import com.asd.activosfijos.repositories.ActivosFijosRepository;
import com.asd.activosfijos.repositories.CiudadesRepository;
import com.asd.activosfijos.util.StateResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivosFijosService {
    @Autowired
    ActivosFijosRepository activosFijosRepository;

    @Autowired
    CiudadesRepository ciudadesRepository;

    private static final Logger LOGGER = LogManager.getLogger();

    public ResponseDTO<List<ActivosFijosModel>> obtenerActivosFijos() {
        try {
            ResponseDTO<List<ActivosFijosModel>> activo = null;
            activo = new ResponseDTO<List<ActivosFijosModel>>(StateResponse.SUCCESS_FIND_ACTIVOS,
                    (ArrayList<ActivosFijosModel>) activosFijosRepository.findAll());
            return activo;
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseDTO<List<ActivosFijosModel>> obtenerActivosFijosFiltro(String tipo, Timestamp fechaCompra, String serial) {              
        try {
            ResponseDTO<List<ActivosFijosModel>> activo = null;
            LOGGER.info("Entra a consulta por los filtros indicados");
            if (tipo != null && fechaCompra != null && serial != null) {
                activo = new ResponseDTO<List<ActivosFijosModel>>(StateResponse.SUCCESS_FIND_ACTIVOS,
                        (ArrayList<ActivosFijosModel>) activosFijosRepository.findActivosFijosFiltros(tipo, serial, fechaCompra));
                        return activo;
            } else if (tipo != null && fechaCompra == null && serial == null) {
                activo = new ResponseDTO<List<ActivosFijosModel>>(StateResponse.SUCCESS_FIND_ACTIVOS,
                        (ArrayList<ActivosFijosModel>) activosFijosRepository.findActivosFijosByTipo(tipo));
                        return activo;
            } else if (tipo != null && fechaCompra != null && serial == null) {
                activo = new ResponseDTO<List<ActivosFijosModel>>(StateResponse.SUCCESS_FIND_ACTIVOS,
                        (ArrayList<ActivosFijosModel>) activosFijosRepository.findActivosFijosByTipoFecha(tipo,
                                fechaCompra));
                                return activo;
            } else if (tipo != null && fechaCompra == null && serial != null) {
                activo = new ResponseDTO<List<ActivosFijosModel>>(StateResponse.SUCCESS_FIND_ACTIVOS,
                        (ArrayList<ActivosFijosModel>) activosFijosRepository.findActivosFijosByTipoSerial(tipo,
                                serial));
                                return activo;
            } else if (tipo == null && fechaCompra != null && serial != null) {
                activo = new ResponseDTO<List<ActivosFijosModel>>(StateResponse.SUCCESS_FIND_ACTIVOS,
                        (ArrayList<ActivosFijosModel>) activosFijosRepository.findActivosFijosByFechaSerial(serial, fechaCompra));
                                return activo;
            } else if (tipo == null && fechaCompra == null && serial != null) {
                activo = new ResponseDTO<List<ActivosFijosModel>>(StateResponse.SUCCESS_FIND_ACTIVOS,
                        (ArrayList<ActivosFijosModel>) activosFijosRepository.findActivosFijosBySerial(serial));
                        return activo;
            } else if (tipo == null && fechaCompra != null && serial == null) {
                activo = new ResponseDTO<List<ActivosFijosModel>>(StateResponse.SUCCESS_FIND_ACTIVOS,
                        (ArrayList<ActivosFijosModel>) activosFijosRepository.findActivosFijosByFecha(fechaCompra));
                        return activo;
            }  
            LOGGER.warn("No se encuentra la combinacion de filtro");
            return activo;          
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    public ResponseDTO<ActivosFijosModel> guardActivosFijosModel(ActivosFijosModel activos) {
        try {            
            if (activos.getId() != null) {
                LOGGER.info("Ingresa a actualizar el registro con id "+activos.getId());
                activos.setFechaHoraModifica(creationTime());
                return new ResponseDTO<ActivosFijosModel>(StateResponse.SUCCESS_UPDATE_ACTIVOS,
                (ActivosFijosModel) activosFijosRepository.save(activos));
            } else {
                LOGGER.info("Ingresa a crear el registro");
                activos.setFechaHoraCrea(creationTime());
                return new ResponseDTO<ActivosFijosModel>(StateResponse.SUCCESS_SAVE_ACTIVOS,
                (ActivosFijosModel) activosFijosRepository.save(activos));
            }                        
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }               
    }

    public ResponseDTO<List<CiudadesModel>> obtenerCiudades(Long idActivo) {
        try {
            ResponseDTO<List<CiudadesModel>> activo = null;
            activo = new ResponseDTO<List<CiudadesModel>>(StateResponse.SUCCESS_FIND_ACTIVOS,
                    (ArrayList<CiudadesModel>) ciudadesRepository.findCiudadesByActivo(idActivo));
            return activo;
        } catch (Exception e) {
            throw e;
        }
    }

    public Timestamp creationTime() {
        Date currentDate = new Date();
        Timestamp ts = new Timestamp(currentDate.getTime());
        return ts;
    }
}
