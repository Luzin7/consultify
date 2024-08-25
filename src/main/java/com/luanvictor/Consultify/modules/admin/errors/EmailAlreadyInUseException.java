package com.luanvictor.Consultify.modules.admin.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)  // Define o status HTTP 409 Conflict
public class EmailAlreadyInUseException extends RuntimeException {
    public EmailAlreadyInUseException() {
        super("Email already in use");
    }
}