package com.research.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "researchers")
public class Researcher {

    @Id
    private String id;

    @NotBlank(message = "Researcher Name is required")
    private String researcherName;

    @Email(message = "Invalid Email")
    private String email;

    @NotBlank(message = "Designation is required")
    private String designation;

    @NotBlank(message = "Department ID is required")
    private String departmentId;
}