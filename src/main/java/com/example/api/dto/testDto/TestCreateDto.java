package com.example.api.dto.testDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestCreateDto {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotEmpty
    private List<Long> applicableDirections;
}
