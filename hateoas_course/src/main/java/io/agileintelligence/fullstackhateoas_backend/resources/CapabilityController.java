package io.agileintelligence.fullstackhateoas_backend.resources;

import io.agileintelligence.fullstackhateoas_backend.domain.Capability;
import io.agileintelligence.fullstackhateoas_backend.services.CapabilityService;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;


@RestController
@RequestMapping("/dashboard")
@CrossOrigin
public class CapabilityController {

    private CapabilityService capabilityService;

    public CapabilityController(CapabilityService capabilityService) {
        this.capabilityService = capabilityService;
    }


    @GetMapping
    public Resources<Resource<Capability>> getAllCapabilities(){

        List<Resource<Capability>> capabilities = capabilityService.getAllCapabilities().stream()
                .map(capability -> new Resource<>(capability,
                        linkTo(methodOn(CapabilityController.class).getCapability(capability.getId())).withRel("getThisCapability"),
                        linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withRel("getAllCapabilities")
                        )).collect(Collectors.toList());

        return new Resources<>(capabilities);

    }

    @GetMapping("/{id}")
    public Resource<?> getCapability(@PathVariable Long id){
        Capability capability = capabilityService.findCapById(id);

        return new Resource<>(capability,
                linkTo(methodOn(CapabilityController.class).getCapability(id)).withRel("getThisCapability"),
                linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withRel("getAllCapabilities")

        );
    }

    @PostMapping
    public Object createCapability(@RequestBody Capability capability){

        Capability newCapability = capabilityService.saveCapability(capability);

        return new Resource<>(newCapability,
                linkTo(methodOn(CapabilityController.class).getCapability(capability.getId())).withRel("getThisCapability"),
                linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withRel("getAllCapabilities")
                );

    }
}