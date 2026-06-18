package com.research.controller;

import com.research.model.ResearchProfile;
import com.research.service.ResearchProfileService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/research-profiles")
public class ResearchProfileController {

    private final ResearchProfileService service;

    public ResearchProfileController(
            ResearchProfileService service) {

        this.service = service;
    }

    @PostMapping
    public ResearchProfile create(
            @Valid @RequestBody ResearchProfile profile){

        return service.save(profile);
    }

    @GetMapping
    public List<ResearchProfile> getAll(){

        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResearchProfile getById(
            @PathVariable String id){

        return service.getById(id);
    }

    @PutMapping("/{id}")
    public ResearchProfile update(
            @PathVariable String id,
            @Valid @RequestBody ResearchProfile profile){

        return service.update(id, profile);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable String id){

        service.delete(id);

        return "Research Profile Deleted Successfully";
    }
}