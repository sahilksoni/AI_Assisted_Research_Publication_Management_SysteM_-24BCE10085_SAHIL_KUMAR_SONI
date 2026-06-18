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
@Document(collection = "publications")
public class Publication {

    @Id
    private String id;

    @NotBlank(message = "Title is required")
    private String title;

    private int publicationYear;

    private String conferenceId;
}