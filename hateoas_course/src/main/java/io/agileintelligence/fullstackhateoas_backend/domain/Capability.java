package io.agileintelligence.fullstackhateoas_backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class Capability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Technology Stack cannot be blank")
    @NotNull(message = "Technology Stack cannot be null")
    private String techStack;
    private Integer numOfDevelopers = 0;
    private Integer numOfAvailableDevelopers = 0;

    public Capability(String techStack, Integer numOfDevelopers, Integer numOfAvailableDevelopers) {
        this.techStack = techStack;
        this.numOfDevelopers = numOfDevelopers;
        this.numOfAvailableDevelopers = numOfAvailableDevelopers;
    }
}
