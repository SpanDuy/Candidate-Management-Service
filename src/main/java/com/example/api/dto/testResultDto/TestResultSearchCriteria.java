package com.example.api.dto.testResultDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.Date;

@Getter
public class TestResultSearchCriteria {
    private Date dateGt;
    private Date dateLt;
    private Integer grade;
}
