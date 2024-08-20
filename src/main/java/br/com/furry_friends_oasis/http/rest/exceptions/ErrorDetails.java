package br.com.furry_friends_oasis.http.rest.exceptions;

public record ErrorDetails(
        Integer status,
        String detail
) {
}
