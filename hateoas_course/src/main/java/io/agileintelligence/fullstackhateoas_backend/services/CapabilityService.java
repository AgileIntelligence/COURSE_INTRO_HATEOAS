package io.agileintelligence.fullstackhateoas_backend.services;

import io.agileintelligence.fullstackhateoas_backend.domain.Capability;
import io.agileintelligence.fullstackhateoas_backend.exceptions.CapabilityException;
import io.agileintelligence.fullstackhateoas_backend.repositories.CapabilityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CapabilityService {

    private CapabilityRepository capabilityRepository;

    public CapabilityService(CapabilityRepository capabilityRepository) {
        this.capabilityRepository = capabilityRepository;
    }

    public List<Capability> getAllCapabilities(){
        return capabilityRepository.findAll();
    }

    public Capability findCapById(Long id){

        return capabilityRepository.findById(id).
                orElseThrow(()-> new CapabilityException("Capability with ID: "+id+" Not found"));

    }

    public Capability saveCapability(Capability capability){
        //
        return capabilityRepository.save(capability);
    }

    public ResponseEntity<?> errorMap(BindingResult result){

        var errorM = new HashMap<>();

        for(FieldError error: result.getFieldErrors()){
            errorM.put(error.getField(),error.getDefaultMessage());
        }

        return new ResponseEntity<>(errorM, HttpStatus.BAD_REQUEST);

    }

    public Capability updateCapability(Long id, Capability capability){

        return capabilityRepository.findById(id).map(
                cap -> {
                    cap.setTechStack(capability.getTechStack());
                    cap.setNumOfDevelopers(capability.getNumOfDevelopers());
                    cap.setNumOfAvailableDevelopers(capability.getNumOfAvailableDevelopers());
                    return capabilityRepository.save(cap);
                }).orElseGet(()-> {
                    return capabilityRepository.save(capability);
                });
    }

    public void deleteCapability(Long id){

        capabilityRepository.delete(
                capabilityRepository.findById(id)
                .orElseThrow(() -> new CapabilityException("Capability with ID: "+id+" Not found")
                ));
    }


}
