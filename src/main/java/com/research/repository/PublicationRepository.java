package com.research.repository;

import com.research.model.Publication;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PublicationRepository
        extends MongoRepository<Publication, String> {

    List<Publication> findByTitleContainingIgnoreCase(
            String keyword);
}