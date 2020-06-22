package com.kshitij.interviews.pokemon.exceptions;

public class NoDataFoundException extends RuntimeException {
    public NoDataFoundException() {
        super();
    }

    public NoDataFoundException(String message) {
        super(message);
    }
}
