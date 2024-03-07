package com.example.api.dto.directionDto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
public class DirectionCreateDto {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
}
