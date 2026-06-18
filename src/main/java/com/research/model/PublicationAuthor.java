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
@Document(collection = "publication_authors")
public class PublicationAuthor {

    @Id
    private String id;

    @NotBlank(message = "Publication ID is required")
    private String publicationId;

    @NotBlank(message = "Researcher ID is required")
    private String researcherId;
}