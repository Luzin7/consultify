package com.luanvictor.Consultify.shared.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidAuthTokenException extends RuntimeException {
    public InvalidAuthTokenException() {
        super("Auth token is invalid");
    }
}