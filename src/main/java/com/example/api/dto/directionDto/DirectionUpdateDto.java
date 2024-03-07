package com.example.api.dto.directionDto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DirectionUpdateDto {
    @NotNull
    private Long id;
    private String name;
    private String description;
}
