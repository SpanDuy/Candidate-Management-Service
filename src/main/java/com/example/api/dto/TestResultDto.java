package com.example.api.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestResultDto {
    private Long id;
    private LocalDateTime date;
    private Integer grade;
}
