package io.agileintelligence.fullstackhateoas_backend.services;

import io.agileintelligence.fullstackhateoas_backend.domain.Capability;
import io.agileintelligence.fullstackhateoas_backend.exceptions.CapabilityException;
import io.agileintelligence.fullstackhateoas_backend.repositories.CapabilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
