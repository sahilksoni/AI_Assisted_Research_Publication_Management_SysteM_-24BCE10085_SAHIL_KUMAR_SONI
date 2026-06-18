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
@Document(collection = "conferences")
public class Conference {

    @Id
    private String id;

    @NotBlank(message = "Conference Name is required")
    private String conferenceName;

    @NotBlank(message = "Location is required")
    private String location;

    private int year;
}