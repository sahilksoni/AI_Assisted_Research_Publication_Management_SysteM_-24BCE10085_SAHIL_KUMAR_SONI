package com.research.service;

import com.research.model.Conference;
import com.research.repository.ConferenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceService {

    private final ConferenceRepository repository;

    public ConferenceService(
            ConferenceRepository repository) {

        this.repository = repository;
    }

    public Conference save(
            Conference conference) {

        return repository.save(conference);
    }

    public List<Conference> getAll() {

        return repository.findAll();
    }

    public Conference getById(
            String id) {

        return repository.findById(id)
                .orElse(null);
    }

    public Conference update(
            String id,
            Conference conference) {

        Conference existing =
                repository.findById(id)
                        .orElse(null);

        if(existing != null) {

            existing.setConferenceName(
                    conference.getConferenceName());

            existing.setLocation(
                    conference.getLocation());

            existing.setYear(
                    conference.getYear());

            return repository.save(existing);
        }

        return null;
    }

    public void delete(
            String id) {

        repository.deleteById(id);
    }
}
