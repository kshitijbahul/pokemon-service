package com.kshitij.interviews.pokemon.exceptions;
/**
 * Exception which is throws by the repository if it is not able to find a character
 */
public class NoDataFoundException extends RuntimeException {
    public NoDataFoundException() {
        super();
    }

    public NoDataFoundException(String message) {
        super(message);
    }
}
