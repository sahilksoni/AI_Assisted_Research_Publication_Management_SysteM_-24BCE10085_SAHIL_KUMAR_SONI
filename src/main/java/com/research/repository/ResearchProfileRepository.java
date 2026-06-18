package com.research.repository;

import com.research.model.ResearchProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResearchProfileRepository
        extends MongoRepository<ResearchProfile,String> {
}