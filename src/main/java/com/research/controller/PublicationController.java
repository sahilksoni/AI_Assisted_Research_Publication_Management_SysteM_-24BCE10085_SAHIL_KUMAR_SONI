package com.research.controller;

import jakarta.validation.Valid;
import com.research.model.Publication;
import com.research.service.PublicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publications")
public class PublicationController {

    private final PublicationService service;

    public PublicationController(
            PublicationService service) {

        this.service = service;
    }

    @PostMapping
    public Publication create(
            @Valid @RequestBody Publication publication){

        return service.save(publication);
    }

    @GetMapping
    public List<Publication> getAll(){

        return service.getAll();
    }

    @GetMapping("/{id}")
    public Publication getById(
            @PathVariable String id){

        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Publication update(
            @PathVariable String id,
            @RequestBody Publication publication){

        return service.update(id, publication);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable String id){

        service.delete(id);

        return "Publication Deleted Successfully";
    }
}