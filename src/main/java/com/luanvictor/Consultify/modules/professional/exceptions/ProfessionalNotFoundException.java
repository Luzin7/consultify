package com.luanvictor.Consultify.modules.professional.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProfessionalNotFoundException extends RuntimeException {
    public ProfessionalNotFoundException() {
        super("Professional not found");
    }
}
