package com.example.api.dto;

import com.example.api.domain.Candidate;
import com.example.api.domain.Test;
import com.example.api.domain.TestResult;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateTestDto {
    private Long id;
    private Candidate candidate;
    private Test test;
    private List<TestResultDto> testResults;
}
