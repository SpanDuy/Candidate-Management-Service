package com.example.api.dto.candidateDto;

import lombok.Getter;

@Getter
public class CandidateSearchCriteria {
    private String firstName;
    private String lastName;
    private String middleName;
    private String photo;
    private String description;
    private String cvFile;
}
