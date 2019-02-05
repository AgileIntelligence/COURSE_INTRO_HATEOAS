package io.agileintelligence.fullstackhateoas_backend.repositories;

import io.agileintelligence.fullstackhateoas_backend.domain.Capability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CapabilityRepository extends JpaRepository<Capability, Long> {


}
