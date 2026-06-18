package com.research.controller;

import com.research.model.Journal;
import com.research.service.JournalService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journals")
public class JournalController {

    private final JournalService service;

    public JournalController(JournalService service) {
        this.service = service;
    }

    @PostMapping
    public Journal create(
            @Valid @RequestBody Journal journal){

        return service.save(journal);
    }

    @GetMapping
    public List<Journal> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Journal getById(
            @PathVariable String id){

        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Journal update(
            @PathVariable String id,
            @Valid @RequestBody Journal journal){

        return service.update(id,journal);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable String id){

        service.delete(id);
        return "Journal Deleted Successfully";
    }
}