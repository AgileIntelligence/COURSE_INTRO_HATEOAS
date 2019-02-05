package io.agileintelligence.fullstackhateoas_backend.data;

import io.agileintelligence.fullstackhateoas_backend.domain.Capability;
import io.agileintelligence.fullstackhateoas_backend.repositories.CapabilityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitialDataLoad {

    @Bean
    CommandLineRunner LoadDB (CapabilityRepository capabilityRepository){
        return args -> { //lambda expression
            capabilityRepository.save(new Capability("Java", 100, 50));
            capabilityRepository.save(new Capability("ReactJS",70,20));
            capabilityRepository.save(new Capability("Python", 200, 100));
        };
    }
}
