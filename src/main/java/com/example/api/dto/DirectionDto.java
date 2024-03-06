package com.example.api.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DirectionDto {
    private Long id;
    private String name;
    private String description;
}
