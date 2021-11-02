package com.asd.activosfijos.controllers;

import java.sql.Timestamp;
import java.util.List;

import com.asd.activosfijos.dto.ResponseDTO;
import com.asd.activosfijos.models.ActivosFijosModel;
import com.asd.activosfijos.models.CiudadesModel;
import com.asd.activosfijos.services.ActivosFijosService;
import com.asd.activosfijos.util.StateResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/asd")
public class ActivosFijosController {

    @Autowired
    ActivosFijosService activosFijosService;

    private static final Logger LOGGER = LogManager.getLogger();

    @CrossOrigin
    @GetMapping("/obtenerActivos")
    @ResponseBody
    @Operation(summary = "Rest Api", responses = {
        @ApiResponse(responseCode = "200", description = "Consulta Exitosa"),
        @ApiResponse(responseCode = "404", description = "Busqueda Sin resultados"),
        @ApiResponse(responseCode = "500", description = "Error Back End")
     })
    public ResponseEntity<ResponseDTO<List<ActivosFijosModel>>> obtenerActivosFijos() {
        ResponseDTO<List<ActivosFijosModel>> response;
        try {
            response = activosFijosService.obtenerActivosFijos();
            LOGGER.info("message");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseDTO<List<ActivosFijosModel>>(StateResponse.ERROR_SOLICITUD_RESPUESTA, null);
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @GetMapping("/obtenerActivosFijos")
    @ResponseBody
    @Operation(summary = "Rest Api", responses = {
            @ApiResponse(responseCode = "200", description = "Consulta Exitosa"),
            @ApiResponse(responseCode = "404", description = "Busqueda Sin resultados"),
            @ApiResponse(responseCode = "500", description = "Error Back End")
         })
    public ResponseEntity<ResponseDTO<List<ActivosFijosModel>>> obtenerActivosFijosFiltro(
            @RequestParam(name = "tipo", required = false) String tipo,
            @RequestParam(name = "fechaCompra", required = false) Timestamp fechaCompra,
            @RequestParam(name = "serial", required = false) String serial) {
        ResponseDTO<List<ActivosFijosModel>> response;
        try {
            response = activosFijosService.obtenerActivosFijosFiltro(tipo, fechaCompra, serial);
            LOGGER.info(response.getStateCode());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseDTO<List<ActivosFijosModel>>(StateResponse.ERROR_SOLICITUD_RESPUESTA, null);
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @PostMapping("/activosFijos")
    @Operation(summary = "Rest Api", responses = {
        @ApiResponse(responseCode = "200", description = "Consulta Exitosa"),
        @ApiResponse(responseCode = "400", description = "Datos Faltantes"),
        @ApiResponse(responseCode = "404", description = "Busqueda Sin resultados"),
        @ApiResponse(responseCode = "500", description = "Error Back End")
     })
    public ResponseEntity<ResponseDTO<ActivosFijosModel>> guardarActivosFijos(@RequestBody ActivosFijosModel activo) {
        ResponseDTO<ActivosFijosModel> responseActivo;
        try {
            responseActivo = activosFijosService.guardActivosFijosModel(activo);
            LOGGER.info(responseActivo.getStateCode());
            return new ResponseEntity<>(responseActivo, HttpStatus.OK);
        } catch (Exception e) {
            responseActivo = new ResponseDTO<ActivosFijosModel>(StateResponse.ERROR_SOLICITUD_RESPUESTA, null);
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(responseActivo, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @GetMapping("/obtenerCiudades")
    @ResponseBody
    @Operation(summary = "Rest Api", responses = {
        @ApiResponse(responseCode = "200", description = "Consulta Exitosa"),
        @ApiResponse(responseCode = "404", description = "Busqueda Sin resultados"),
        @ApiResponse(responseCode = "500", description = "Error Back End")
     })
    public ResponseEntity<ResponseDTO<List<CiudadesModel>>> obtenerCiudades(
        @RequestParam(name = "idActivo", required = false) Long idActivo
    ) {
        ResponseDTO<List<CiudadesModel>> response;
        try {
            response = activosFijosService.obtenerCiudades(idActivo);
            LOGGER.info("message");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseDTO<List<CiudadesModel>>(StateResponse.ERROR_SOLICITUD_RESPUESTA, null);
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
