package com.research.repository;

import com.research.model.Researcher;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ResearcherRepository
        extends MongoRepository<Researcher,String> {

    List<Researcher> findByResearcherNameContainingIgnoreCase(
            String name);
}