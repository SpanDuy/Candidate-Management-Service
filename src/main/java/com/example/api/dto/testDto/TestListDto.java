package com.example.api.dto.testDto;


import com.example.api.dto.directionDto.DirectionListDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestListDto {
    private Long id;
    private String name;
    private String description;
    private List<DirectionListDto> applicableDirections;
}
