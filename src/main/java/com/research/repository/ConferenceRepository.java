package com.research.repository;

import com.research.model.Conference;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConferenceRepository
        extends MongoRepository<Conference,String> {
}