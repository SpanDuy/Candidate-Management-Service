package com.example.api.dto.candidateTestDto;

import com.example.api.dto.testResultDto.TestResultSearchCriteria;
import lombok.Getter;

@Getter
public class CandidateTestSearchCriteria {
    private TestResultSearchCriteria testResults;
}
