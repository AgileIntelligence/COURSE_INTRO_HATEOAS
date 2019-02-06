package io.agileintelligence.fullstackhateoas_backend.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CapabilityNotFoundResponse {

    private String capabilityNotFound;

    public CapabilityNotFoundResponse(String capabilityNotFound) {
        this.capabilityNotFound = capabilityNotFound;
    }
}
