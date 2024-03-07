package com.example.api.dto.testResultDto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestResultDto {
    @NotBlank
    private Date date;
    @NotBlank
    private Integer grade;
}
