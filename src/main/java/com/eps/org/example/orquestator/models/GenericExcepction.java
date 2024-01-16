package com.eps.org.example.orquestator.models;

public class GenericExcepction {

    private String message;
    private int codeError;

    public GenericExcepction(String message, int codeError) {
        this.message = message;
        this.codeError = codeError;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCodeError() {
        return this.codeError;
    }

    public void setCodeError(int codeError) {
        this.codeError = codeError;
    }
}
