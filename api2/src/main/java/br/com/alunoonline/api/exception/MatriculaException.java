package br.com.alunoonline.api.exception;

public class MatriculaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MatriculaException(String message) {
        super(message);
    }

    public MatriculaException(String message, Throwable cause) {
        super(message, cause);
    }
}

