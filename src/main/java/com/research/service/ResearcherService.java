package com.research.service;

import com.research.model.Researcher;
import com.research.repository.ResearcherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResearcherService {

    private final ResearcherRepository repository;

    public ResearcherService(ResearcherRepository repository) {
        this.repository = repository;
    }

    public Researcher save(Researcher researcher){
        return repository.save(researcher);
    }

    public List<Researcher> getAll(){
        return repository.findAll();
    }

    public Researcher getById(String id){
        return repository.findById(id).orElse(null);
    }

    public Researcher update(String id,
                             Researcher researcher){

        Researcher existing =
                repository.findById(id).orElse(null);

        if(existing != null){

            existing.setResearcherName(
                    researcher.getResearcherName());

            existing.setEmail(
                    researcher.getEmail());

            existing.setDesignation(
                    researcher.getDesignation());

            existing.setDepartmentId(
                    researcher.getDepartmentId());

            return repository.save(existing);
        }

        return null;
    }

    public void delete(String id){
        repository.deleteById(id);
    }
}