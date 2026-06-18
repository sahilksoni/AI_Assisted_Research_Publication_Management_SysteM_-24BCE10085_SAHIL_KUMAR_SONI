package com.research.scholar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.research.model.Publication;
import org.springframework.web.bind.annotation.RequestParam;
import com.research.model.Researcher;

import java.util.List;

@RestController
@RequestMapping("/scholar")
public class ScholarController {

    private final ScholarService scholarService;

    public ScholarController(
            ScholarService scholarService) {

        this.scholarService = scholarService;
    }

    @GetMapping("/dashboard")
    public DashboardResponse dashboard() {

        return scholarService.getDashboard();
    }
    @GetMapping("/search-publication")
    public List<Publication> searchPublication(
            @RequestParam String keyword) {

        return scholarService
                .searchPublication(keyword);
    }
    @GetMapping("/search-researcher")
    public List<Researcher> searchResearcher(
            @RequestParam String name){

        return scholarService
                .searchResearcher(name);
    }
}