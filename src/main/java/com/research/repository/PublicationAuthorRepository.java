package com.research.repository;

import com.research.model.PublicationAuthor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PublicationAuthorRepository
        extends MongoRepository<PublicationAuthor, String> {
}