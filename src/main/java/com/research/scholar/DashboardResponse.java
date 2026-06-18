package com.research.scholar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponse {

    private String currentDate;
    private String currentTime;
    private String motivation;


    private long totalDepartments;
    private long totalResearchers;
    private long totalPublications;
    private long totalJournals;
    private long totalConferences;
    private String status;
}