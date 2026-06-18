package com.research.controller;


import jakarta.validation.Valid;
import com.research.model.Conference;
import com.research.service.ConferenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conferences")
public class ConferenceController {

    private final ConferenceService service;

    public ConferenceController(
            ConferenceService service) {

        this.service = service;
    }

    @PostMapping
    public Conference create(
            @Valid @RequestBody Conference conference){

        return service.save(conference);
    }

    @GetMapping
    public List<Conference> getAll(){

        return service.getAll();
    }

    @GetMapping("/{id}")
    public Conference getById(
            @PathVariable String id){

        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Conference update(
            @PathVariable String id,
            @RequestBody Conference conference){

        return service.update(id, conference);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable String id){

        service.delete(id);

        return "Conference Deleted Successfully";
    }
}