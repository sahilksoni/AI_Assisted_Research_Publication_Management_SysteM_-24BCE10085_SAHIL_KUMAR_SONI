package com.research.service;

import com.research.model.Publication;
import com.research.repository.PublicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationService {

    private final PublicationRepository repository;

    public PublicationService(
            PublicationRepository repository) {

        this.repository = repository;
    }

    public Publication save(
            Publication publication) {

        return repository.save(publication);
    }

    public List<Publication> getAll() {

        return repository.findAll();
    }

    public Publication getById(
            String id) {

        return repository.findById(id)
                .orElse(null);
    }

    public Publication update(
            String id,
            Publication publication) {

        Publication existing =
                repository.findById(id)
                        .orElse(null);

        if(existing != null) {

            existing.setTitle(
                    publication.getTitle());

            existing.setPublicationYear(
                    publication.getPublicationYear());

            existing.setConferenceId(
                    publication.getConferenceId());

            return repository.save(existing);
        }

        return null;
    }

    public void delete(
            String id) {

        repository.deleteById(id);
    }
}