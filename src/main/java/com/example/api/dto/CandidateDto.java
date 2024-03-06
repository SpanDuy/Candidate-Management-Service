package com.example.api.dto;

import com.example.api.domain.Direction;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String photo;
    private String description;
    private String cvFile;
    private List<DirectionDto> possibleDirections;
}
