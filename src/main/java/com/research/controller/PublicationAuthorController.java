package com.research.controller;

import jakarta.validation.Valid;
import com.research.model.PublicationAuthor;
import com.research.service.PublicationAuthorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publication-authors")
public class PublicationAuthorController {

    private final PublicationAuthorService service;

    public PublicationAuthorController(
            PublicationAuthorService service) {

        this.service = service;
    }

    @PostMapping
    public PublicationAuthor create(
            @Valid  @RequestBody PublicationAuthor publicationAuthor){

        return service.save(publicationAuthor);
    }

    @GetMapping
    public List<PublicationAuthor> getAll(){

        return service.getAll();
    }

    @GetMapping("/{id}")
    public PublicationAuthor getById(
            @PathVariable String id){

        return service.getById(id);
    }

    @PutMapping("/{id}")
    public PublicationAuthor update(
            @PathVariable String id,
            @RequestBody PublicationAuthor publicationAuthor){

        return service.update(id, publicationAuthor);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable String id){

        service.delete(id);

        return "Publication Author Deleted Successfully";
    }
}