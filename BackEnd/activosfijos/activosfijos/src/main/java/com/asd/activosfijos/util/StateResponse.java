package com.asd.activosfijos.util;

public enum StateResponse {
    
    /**
     * {@code 200 ok}
     */
    OK(200, "Ok"),

    /**
     * {@code 001 Consulta exitosa}
     */
    SUCCESS_FIND_ACTIVOS(001, "Consulta exitosa!"),

    /**
     * {@code 002 Error en Consulta}
     */
    ERROR_SOLICITUD_RESPUESTA(002, "Error en consulta!"),

    /**
     * {@code 003 Registro guardado exitosamente}
     */
    SUCCESS_SAVE_ACTIVOS(003, "Registro guardado exitosamente!"),

    /**
     * {@code 004 Registro actualizado exitosamente}
     */
    SUCCESS_UPDATE_ACTIVOS(004, "Registro actualizado exitosamente!")
    ;

    private final int code;

    private final String description;

    private StateResponse(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
    
}
