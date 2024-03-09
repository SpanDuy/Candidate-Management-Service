package com.example.api.dto.candidateDto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
public class CandidateCreateDto {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String middleName;
    private String photo;
    private String description;
    private String cvFile;
    private List<Long> possibleDirections;
}
