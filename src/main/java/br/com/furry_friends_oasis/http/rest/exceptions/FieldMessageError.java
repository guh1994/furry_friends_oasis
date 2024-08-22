package br.com.furry_friends_oasis.http.rest.exceptions;

import org.springframework.validation.FieldError;

public record FieldMessageError(String fieldName, String message) {

    FieldMessageError(FieldError fieldError) {
        this(fieldError.getField(), fieldError.getDefaultMessage());
    }
}
