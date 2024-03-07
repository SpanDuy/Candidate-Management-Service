package com.example.api.dto.testDto;


import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestUpdateDto {
    @NotNull
    private Long id;
    private String name;
    private String description;
    private List<Long> applicableDirections;
}
