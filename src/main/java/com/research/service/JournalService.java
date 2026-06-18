package com.research.service;

import com.research.model.Journal;
import com.research.repository.JournalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalService {

    private final JournalRepository repository;

    public JournalService(JournalRepository repository) {
        this.repository = repository;
    }

    public Journal save(Journal journal){
        return repository.save(journal);
    }

    public List<Journal> getAll(){
        return repository.findAll();
    }

    public Journal getById(String id){
        return repository.findById(id).orElse(null);
    }

    public Journal update(String id, Journal journal){

        Journal existing =
                repository.findById(id).orElse(null);

        if(existing != null){

            existing.setJournalName(
                    journal.getJournalName());

            existing.setPublisher(
                    journal.getPublisher());

            existing.setImpactFactor(
                    journal.getImpactFactor());

            return repository.save(existing);
        }

        return null;
    }

    public void delete(String id){
        repository.deleteById(id);
    }
}