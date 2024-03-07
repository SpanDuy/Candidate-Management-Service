package com.example.api.dto.candidateDto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateUpdateDto {
    @NotNull
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String photo;
    private String description;
    private String cvFile;
    private List<Long> possibleDirections;
}
