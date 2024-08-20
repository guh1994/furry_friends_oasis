package br.com.furry_friends_oasis.http.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllersExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleInternalServerErrors(Exception ex) {
        var error = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error: " + ex.getLocalizedMessage());
        return ResponseEntity.status(error.status()).body(error);
    }

}
