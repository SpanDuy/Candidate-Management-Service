package com.example.api.dto;

import com.example.api.domain.Direction;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {
    private Long id;
    private String name;
    private String description;
    private List<DirectionDto> applicableDirections;
}
