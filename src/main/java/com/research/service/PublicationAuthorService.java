package com.research.service;

import com.research.model.PublicationAuthor;
import com.research.repository.PublicationAuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationAuthorService {

    private final PublicationAuthorRepository repository;

    public PublicationAuthorService(
            PublicationAuthorRepository repository) {

        this.repository = repository;
    }

    public PublicationAuthor save(
            PublicationAuthor publicationAuthor) {

        return repository.save(publicationAuthor);
    }

    public List<PublicationAuthor> getAll() {

        return repository.findAll();
    }

    public PublicationAuthor getById(
            String id) {

        return repository.findById(id)
                .orElse(null);
    }

    public PublicationAuthor update(
            String id,
            PublicationAuthor publicationAuthor) {

        PublicationAuthor existing =
                repository.findById(id)
                        .orElse(null);

        if(existing != null) {

            existing.setPublicationId(
                    publicationAuthor.getPublicationId());

            existing.setResearcherId(
                    publicationAuthor.getResearcherId());

            return repository.save(existing);
        }

        return null;
    }

    public void delete(
            String id) {

        repository.deleteById(id);
    }
}