package com.research.scholar;

import com.research.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import com.research.model.Publication;
import java.util.List;
import com.research.model.Researcher;

@Service
public class ScholarService {

    private final DepartmentRepository departmentRepository;
    private final ResearcherRepository researcherRepository;
    private final PublicationRepository publicationRepository;
    private final JournalRepository journalRepository;
    private final ConferenceRepository conferenceRepository;

    public ScholarService(
            DepartmentRepository departmentRepository,
            ResearcherRepository researcherRepository,
            PublicationRepository publicationRepository,
            JournalRepository journalRepository,
            ConferenceRepository conferenceRepository) {

        this.departmentRepository = departmentRepository;
        this.researcherRepository = researcherRepository;
        this.publicationRepository = publicationRepository;
        this.journalRepository = journalRepository;
        this.conferenceRepository = conferenceRepository;
    }
    private final String[] quotes = {
            "Research is creating new knowledge.",
            "Innovation distinguishes leaders from followers.",
            "Every discovery starts with curiosity.",
            "Knowledge grows when shared.",
            "The best way to predict the future is to invent it.",
            "Research today, impact tomorrow."
    };

    public DashboardResponse getDashboard() {

        return new DashboardResponse(


                LocalDate.now().toString(),
                LocalTime.now().withNano(0).toString(),
                quotes[(int)(Math.random() * quotes.length)],

                departmentRepository.count(),
                researcherRepository.count(),
                publicationRepository.count(),
                journalRepository.count(),
                conferenceRepository.count(),
                "ACTIVE"
        );
    }
    public List<Publication> searchPublication(
            String keyword) {

        return publicationRepository
                .findByTitleContainingIgnoreCase(
                        keyword);
    }
    public List<Researcher> searchResearcher(
            String name){

        return researcherRepository
                .findByResearcherNameContainingIgnoreCase(
                        name);
    }
}