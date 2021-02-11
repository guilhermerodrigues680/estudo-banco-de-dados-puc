package com.db.estudo.repositorio;

public class RepositorioGenericException extends Exception{

    public RepositorioGenericException() {
    }

    public RepositorioGenericException(String message) {
        super(message);
    }

    public RepositorioGenericException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepositorioGenericException(Throwable cause) {
        super(cause);
    }

}
