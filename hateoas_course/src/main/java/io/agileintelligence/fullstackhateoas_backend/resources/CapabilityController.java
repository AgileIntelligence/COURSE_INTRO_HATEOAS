package io.agileintelligence.fullstackhateoas_backend.resources;

import io.agileintelligence.fullstackhateoas_backend.domain.Capability;
import io.agileintelligence.fullstackhateoas_backend.services.CapabilityService;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Object createCapability(@Valid @RequestBody Capability capability, BindingResult result){

        if(result.hasErrors()) return capabilityService.errorMap(result);

        Capability newCapability = capabilityService.saveCapability(capability);

        return new Resource<>(newCapability,
                linkTo(methodOn(CapabilityController.class).getCapability(newCapability.getId())).withRel("getThisCapability"),
                linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withRel("getAllCapabilities")
                );

    }

    @PutMapping("/{id}")
    public Object updateCapability(@PathVariable Long id, @Valid @RequestBody Capability capability, BindingResult result){
        if(result.hasErrors()) return capabilityService.errorMap(result);

        Capability capabilityToUpdate = capabilityService.updateCapability(id,capability);

        return new Resource<>(capabilityToUpdate,
                linkTo(methodOn(CapabilityController.class).getCapability(capabilityToUpdate.getId())).withRel("getThisCapability"),
                linkTo(methodOn(CapabilityController.class).getAllCapabilities()).withRel("getAllCapabilities")
                );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCapability(@PathVariable Long id){
        capabilityService.deleteCapability(id);

        return new ResponseEntity<String>("Capability Deleted", HttpStatus.OK);
    }

}
