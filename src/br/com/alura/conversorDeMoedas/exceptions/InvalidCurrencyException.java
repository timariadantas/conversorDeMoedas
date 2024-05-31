package br.com.alura.conversorDeMoedas.exceptions;

public class InvalidCurrencyException extends RuntimeException{
    private String message;

    public InvalidCurrencyException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
