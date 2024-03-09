package com.example.api.dto.directionDto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
public class DirectionCreateDto {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
}
