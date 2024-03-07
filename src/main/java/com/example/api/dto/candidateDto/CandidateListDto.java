package com.example.api.dto.candidateDto;


import com.example.api.dto.directionDto.DirectionListDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateListDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String photo;
    private String description;
    private String cvFile;
    private List<DirectionListDto> possibleDirections;
}
