package com.asd.activosfijos.dto;


import com.asd.activosfijos.util.StateResponse;

public class ResponseDTO<T> {
    private String stateCode;
    private String stateMessage;
    private T result;
    
    public ResponseDTO(String stateCode, String stateMessage, T result) {
        this.stateCode = stateCode;
        this.stateMessage = stateMessage;
        this.result = result;
    }

    public ResponseDTO(StateResponse satus, T result) {
        this.stateCode = String.valueOf(satus.getCode());
        this.stateMessage = satus.getDescription();
        this.result = result;
    }

    public void ResponseExeption(StateResponse satus, String exeption) {
        this.stateCode = String.valueOf(satus.getCode());
        this.stateMessage = satus.getDescription() + exeption;
    }

    public String getStateCode() {
        return stateCode;
    }
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
    public String getStateMessage() {
        return stateMessage;
    }
    public void setStateMessage(String stateMessage) {
        this.stateMessage = stateMessage;
    }
    public T getResult() {
        return result;
    }
    public void setResult(T result) {
        this.result = result;
    }

    
}
