package com.research.service;

import com.research.model.ResearchProfile;
import com.research.repository.ResearchProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResearchProfileService {

    private final ResearchProfileRepository repository;

    public ResearchProfileService(
            ResearchProfileRepository repository) {

        this.repository = repository;
    }

    public ResearchProfile save(
            ResearchProfile profile) {

        return repository.save(profile);
    }

    public List<ResearchProfile> getAll() {

        return repository.findAll();
    }

    public ResearchProfile getById(
            String id) {

        return repository.findById(id)
                .orElse(null);
    }

    public ResearchProfile update(
            String id,
            ResearchProfile profile) {

        ResearchProfile existing =
                repository.findById(id)
                        .orElse(null);

        if(existing != null) {

            existing.setResearcherId(
                    profile.getResearcherId());

            existing.setSpecialization(
                    profile.getSpecialization());

            existing.setExperienceYears(
                    profile.getExperienceYears());

            return repository.save(existing);
        }

        return null;
    }

    public void delete(
            String id) {

        repository.deleteById(id);
    }
}