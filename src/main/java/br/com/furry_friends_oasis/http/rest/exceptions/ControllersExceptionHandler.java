package br.com.furry_friends_oasis.http.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ControllersExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails<List<FieldMessageError>>> handleFieldValidationErrors(MethodArgumentNotValidException ex) {
        var fieldErrors = ex.getFieldErrors();

        var fieldErrorList = fieldErrors.stream()
                .map(FieldMessageError::new)
                .toList();

        var details = new ErrorDetails<>(HttpStatus.BAD_REQUEST.value(), fieldErrorList);
        return ResponseEntity.status(details.status()).body(details);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDetails<String>> handleHttpNotReaadableError(HttpMessageNotReadableException ex) {
        var details = new ErrorDetails<>(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(details.status()).body(details);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails<String>> handleInternalServerErrors(Exception ex) {
        var details = new ErrorDetails<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error: " + ex.getLocalizedMessage());
        return ResponseEntity.status(details.status()).body(details);
    }

}
