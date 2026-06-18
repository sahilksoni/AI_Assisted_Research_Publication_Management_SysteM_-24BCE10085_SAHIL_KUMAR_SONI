package com.research.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "research_profiles")
public class ResearchProfile {

    @Id
    private String id;

    @NotBlank
    private String researcherId;

    private String specialization;

    private int experienceYears;
}