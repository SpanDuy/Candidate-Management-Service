package com.example.api.dto.directionDto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DirectionListDto {
    private Long id;
    private String name;
    private String description;
}
