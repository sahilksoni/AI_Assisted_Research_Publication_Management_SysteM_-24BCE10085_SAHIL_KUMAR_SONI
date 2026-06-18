package com.research.controller;

import jakarta.validation.Valid;
import com.research.model.Researcher;
import com.research.service.ResearcherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/researchers")
public class ResearcherController {

    private final ResearcherService service;

    public ResearcherController(
            ResearcherService service) {

        this.service = service;
    }

    @PostMapping
    public Researcher create(
            @Valid @RequestBody Researcher researcher){

        return service.save(researcher);
    }

    @GetMapping
    public List<Researcher> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Researcher getById(
            @PathVariable String id){

        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Researcher update(
            @PathVariable String id,
            @RequestBody Researcher researcher){

        return service.update(id,researcher);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable String id){

        service.delete(id);

        return "Researcher Deleted Successfully";
    }
}