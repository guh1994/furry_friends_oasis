package br.com.furry_friends_oasis.http.rest.exceptions;

public record ErrorDetails<T>(
        Integer status,
        T detail
) {
}
