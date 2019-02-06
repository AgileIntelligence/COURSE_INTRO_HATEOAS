package io.agileintelligence.fullstackhateoas_backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class CapabilityException extends RuntimeException {
    public CapabilityException(String message) {
        super(message);
    }
}
