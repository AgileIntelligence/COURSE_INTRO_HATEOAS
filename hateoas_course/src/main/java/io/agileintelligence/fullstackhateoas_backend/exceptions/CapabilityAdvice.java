package io.agileintelligence.fullstackhateoas_backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CapabilityAdvice {

    @ResponseBody
    @ExceptionHandler(CapabilityException.class)
    public final ResponseEntity<Object> capabilityNotFoundResponseResponseEntity(CapabilityException ex){
        CapabilityNotFoundResponse response = new CapabilityNotFoundResponse(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
