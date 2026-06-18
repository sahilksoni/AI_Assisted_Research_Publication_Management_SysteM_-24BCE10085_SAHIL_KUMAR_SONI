package com.research.repository;

import com.research.model.Journal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalRepository
        extends MongoRepository<Journal,String> {
}